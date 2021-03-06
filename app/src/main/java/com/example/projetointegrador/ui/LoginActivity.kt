package com.example.projetointegrador.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.WhichButton
import com.afollestad.materialdialogs.actions.setActionButtonEnabled
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
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
import com.google.firebase.auth.*
import com.google.firebase.internal.InternalTokenProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    private var usernameSucesso = true
    private lateinit var callbackManager: CallbackManager
    private val scope = CoroutineScope(Dispatchers.Main)
    val TAG = "LOGIN ACTIVITY"

    //    private var RC_SIGN_IN = 100
    val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbApp = AppDataBase.invoke(this)
        dbRepository = DBRepositoryImplementation(
            dbApp.TemplateDAO(),
            dbApp.FilmeReplaceDAO(),
            dbApp.ConfiguracoesDAO(),
            dbApp.PaisMappingDAO()
        )
        connect()
        initializePaisesMapping()

        onBackPressedDispatcher.addCallback(this) {
            exitProcess(0)
        }


        viewModel.jaTemUsername.observe(this, { jaTemUsername ->
            if (jaTemUsername) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                solicitarUsername()
            }
        })

        viewModel.usernameCriado.observe(this, { usernameCriado ->
            if (usernameCriado) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username indisponível, escolha outro.", Toast.LENGTH_SHORT).show()
            }
        })

        binding.tvEsqueciSenha.setOnClickListener {
            val intent = Intent(this, NewPasswordActivity::class.java)
            startActivity(intent)
        }


        binding.btnLogin.setOnClickListener {
            getDataFields()
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


    fun getDataFields(){
        val email = binding.username.text.toString()
        val password = binding.password.text.toString()
        if(!email.isEmpty() && !password.isEmpty()) signInEmailPwd(email, password)
        else showMsg("Preencha todos os campos!")
    }

    fun signInEmailPwd(email: String, pwd: String){
        auth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener {
            if(it.isSuccessful){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                showMsg("Email ou Senha inválidos!")
                Log.i(TAG, it.exception.toString())
            }
        }
    }



    fun connect() {
        //Inicializar Firebase auth
        auth = FirebaseAuth.getInstance()

        //Configurar google sign in
        googleSignOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignOptions)

        //Inicializar botao de login do facebook
        callbackManager = CallbackManager.Factory.create()
    }

    fun initializePaisesMapping(){
        scope.launch {
            if (dbRepository.testIsEmptyDBService() == null) {
                Log.i("*******", "Tabela países é nula")
                dbRepository.populatePaisesMappingDBService()
            }
            else {
                val country = dbRepository.getPaisPortuguesDBService("Brazil")
                Log.i("*******", "Tabela países não é mais nula")
                Log.i("*******", "Tabela países não é mais nula")
                Log.i("*******", "Tabela países não é mais nula")
                Log.i("*******", "Tabela países não é mais nula")
                Log.i("*******", "Tabela países não é mais nula")
                Log.i("País", country)
            }
        }
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
                Log.i(TAG, ignored.toString())
            }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {

        showProgressBar()

        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    viewModel.getConfigurationForUser(user!!.email.toString())
                    viewModel.configuracoes.observe(this, {
                        if (it == null) viewModel.createConfigurationForUser(user.email.toString())
                        viewModel.updateFacebookLogIn(true)
                        viewModel.verificarSeTemUsername()
                    })
                }

                hideProgressBar()
            }
    }


    fun solicitarUsername() {

        val dialogUsername = MaterialDialog(this)

        dialogUsername.show {

            message(R.string.insira_usuario)

            input(maxLength = 20) { dialog, text ->
                viewModel.criarUsername(text.toString())

                val inputField = dialog.getInputField()
                val naoTemUsername = !viewModel.jaTemUsername.value!!

                inputField.error = if (naoTemUsername) null else "Username já existe, escolha outro"

                dialog.setActionButtonEnabled(WhichButton.POSITIVE, !naoTemUsername)
            }

            positiveButton(R.string.ok)
        }
    }


    fun signInWithGoogle() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
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
                        viewModel.verificarSeTemUsername()
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

    fun showMsg(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}