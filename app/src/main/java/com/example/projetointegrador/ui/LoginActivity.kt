package com.example.projetointegrador.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.databinding.ActivityLoginBinding
import com.example.projetointegrador.services.DBRepositoryImplementation
import com.example.projetointegrador.services.dbApp
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.system.exitProcess

//keytool -keystore path-to-debug-or-production-keystore -list -v
//ID do cliente 126573344939-6586nerf79c5gggkko08m7eeh1ep9ar5.apps.googleusercontent.com

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var googleSignOptions: GoogleSignInOptions
    private lateinit var auth: FirebaseAuth
    private lateinit var progressView: ViewGroup
    private var progressoVisivel = false
    private lateinit var callbackManager: CallbackManager
    val TAG = "LOGIN ACTIVITY"

    //    private var RC_SIGN_IN = 100
    val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDB()

        dbRepository = DBRepositoryImplementation(
            dbApp.TemplateDAO(),
            dbApp.FilmeReplaceDAO(),
            dbApp.ConfiguracoesDAO()
        )

        onBackPressedDispatcher.addCallback(this) {
            exitProcess(0)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.getConfigurationForUser(binding.username.text.toString())
            viewModel.configuracoes.observe(this, {
                if (it == null) Toast.makeText(this, "EMAIL INVÁLIDO!", Toast.LENGTH_LONG).show()
                else {
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

        binding.ivFacebook.setOnClickListener {
            binding.lbtnFacebook.performClick()
        }

        binding.ivLoginGoogle.setOnClickListener {
            signInWithGoogle()
        }

        //Configurar google sign in
        googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignOptions)

        //Inicializar Firebase auth
        auth = Firebase.auth

        //Inicializar botao de login do facebook
        callbackManager = CallbackManager.Factory.create()

        binding.lbtnFacebook.setReadPermissions("email", "public_profile")
        binding.lbtnFacebook.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {

                override fun onSuccess(result: LoginResult?) {
                    handleFacebookAccessToken(result!!.accessToken)
                }

                override fun onCancel() {
                }

                override fun onError(error: FacebookException?) {
                }
            })
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (ignored: Exception) {
            }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun signInWithGoogle() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {

        showProgressBar()

        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(this, "Login falhou :(", Toast.LENGTH_SHORT).show()
                }

                hideProgressBar()
            }
    }

    private fun showProgressBar() {
        if (!progressoVisivel) {
            progressoVisivel = true
            progressView = layoutInflater.inflate(R.layout.progressbar_layout, null) as ViewGroup
            //Centralizar progress bar
            progressView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val view = binding.root
            val viewGroup: ViewGroup = view as ViewGroup
            viewGroup.addView(progressView)
        }
    }

    private fun hideProgressBar() {
        val view = binding.root
        val viewGroup: ViewGroup = view as ViewGroup
        viewGroup.removeView(progressView)
        progressoVisivel = false
    }

    private fun initDB() {
        dbApp = AppDataBase.invoke(this)
    }

    private fun handleFacebookAccessToken(token: AccessToken) {

        showProgressBar()

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    viewModel.getConfigurationForUser(user!!.email.toString())
                    viewModel.configuracoes.observe(this, {
                        if (it == null) viewModel.createConfigurationForUser(user.email.toString())
                        viewModel.updateFacebookLogIn(true)
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("email", user.email)
                        startActivity(intent)
                    })
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Não deu bom", "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Login falhou",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                hideProgressBar()
            }
    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}