package com.example.projetointegrador.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.viewModels
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.databinding.ActivityLoginBinding
import com.example.projetointegrador.services.DBRepositoryImplementation
import com.example.projetointegrador.services.dbApp
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.system.exitProcess

//keytool -keystore path-to-debug-or-production-keystore -list -v
//ID do cliente 126573344939-6586nerf79c5gggkko08m7eeh1ep9ar5.apps.googleusercontent.com

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private var RC_SIGN_IN = 100
    val viewModel by viewModels<MainViewModel>{
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

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        ivLoginGoogle.setOnClickListener {
            signIn()
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
    }
    /*
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val personName = acct.displayName
                val personGivenName = acct.givenName
                val personFamilyName = acct.familyName
                val personEmail = acct.email
                val personId = acct.id
                val personPhoto: Uri? = acct.photoUrl

                Toast.makeText(this, "user: $personName", Toast.LENGTH_SHORT).show()
                //personName?.let { openHome(it) }
                personEmail?.let { openHome(it) }
            }
        } catch (e: ApiException) {
            Log.d("signInResult: ", e.toString())
        }
    }
     */

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val personName = acct.displayName
                val personGivenName = acct.givenName
                val personFamilyName = acct.familyName
                val personEmail = acct.email
                val personId = acct.id
                val personPhoto: Uri? = acct.photoUrl

                viewModel.getConfigurationForUser(personEmail!!)
                viewModel.configuracoes.observe(this, {
                    if(it == null) Toast.makeText(this, "EMAIL INEXISTENTE, POR FAVOR CADASTRE-SE ANTES DE FAZER LOGIN!", Toast.LENGTH_LONG).show()
                    else{
                        Toast.makeText(this, "user: $personName", Toast.LENGTH_SHORT).show()
                        //personName?.let { openHome(it) }
                        personEmail?.let { openHome(it) }
                    }
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
}