package com.example.projetointegrador.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.viewModels
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.databinding.ActivityLoginBinding
import com.example.projetointegrador.services.*
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_pergunta.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.security.auth.callback.Callback
import javax.security.auth.callback.CallbackHandler
import kotlin.system.exitProcess

//keytool -keystore path-to-debug-or-production-keystore -list -v
//ID do cliente 126573344939-6586nerf79c5gggkko08m7eeh1ep9ar5.apps.googleusercontent.com

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth : FirebaseAuth
    val callbackManager = CallbackManager.Factory.create()
    val TAG = "LOGIN ACTIVITY"

    private var RC_SIGN_IN = 100
    val viewModel by viewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDB()
        auth = FirebaseAuth.getInstance()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
//        viewModel.configFacebook(auth)
//        viewModel.configGoogle(googleSignInClient)



        binding.ivFacebook.setOnClickListener {
            onClickFacebook(binding.ivFacebook)
        }


        dbRepository = DBRepositoryImplementation(
            dbApp.TemplateDAO(),
            dbApp.FilmeReplaceDAO(),
            dbApp.ConfiguracoesDAO()
        )

        onBackPressedDispatcher.addCallback(this){
            exitProcess(0)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.getConfigurationForUser(binding.username.text.toString())
            viewModel.configuracoes.observe(this, {
                if(it == null) Toast.makeText(this, "EMAIL INVÁLIDO!", Toast.LENGTH_LONG).show()
                else{
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("email", binding.username.text.toString())
                    startActivity(intent)
                }
            })
        }

        binding.tvCadastreSe.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }





        ivLoginGoogle.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", currentUser.email)
            startActivity(intent)
        }
    }

    fun signIn() {
        val signInIntent: Intent = googleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val acct = completedTask.getResult(ApiException::class.java)
            //val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val personName = acct.displayName
                val personGivenName = acct.givenName
                val personFamilyName = acct.familyName
                val personEmail = acct.email
                val personId = acct.id
                val personPhoto: Uri? = acct.photoUrl

                viewModel.getConfigurationForUser(personEmail!!)
                viewModel.configuracoes.observe(this, {
                    if(it == null) viewModel.createConfigurationForUser(personEmail)
                    Log.i(TAG, "logou no google")
                    viewModel.updateGoogleLogIn(true)
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("email", personEmail)
                    startActivity(intent)
                })

            }
        } catch (e: ApiException) {
            Log.d("signInResult: ", e.toString())
        }
    }

    fun openHome(msg: String){
        val intent = Intent(this, HomeActivity::class.java).apply {
            //putExtra("name",msg)
            putExtra("email", msg)
        }
        startActivity(intent)
    }

    fun initDB() {
        dbApp = AppDataBase.invoke(this)
    }

    fun configFacebookButton(){
        binding.lbtnFacebook.setReadPermissions("email", "public_profile")
        binding.lbtnFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                handleFacebookAccessToken(result!!.accessToken)
            }

            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onError(error: FacebookException?) {
                TODO("Not yet implemented")
            }

        })
    }


    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    viewModel.getConfigurationForUser(user!!.email.toString())
                    viewModel.configuracoes.observe(this, {
                        if(it == null) viewModel.createConfigurationForUser(user.email.toString())
                        viewModel.updateFacebookLogIn(true)
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("email", user.email)
                        startActivity(intent)
                    })
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Não deu bom", "signInWithCredential:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

                // ...
            }
    }

    fun onClickFacebook(v : View){
        if(v == binding.ivFacebook){
            binding.lbtnFacebook.performClick()
            configFacebookButton()
        }
    }



}