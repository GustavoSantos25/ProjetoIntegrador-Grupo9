package com.example.projetointegrador.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.viewModels
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.ActivityCadastroBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlin.system.exitProcess

class CadastroActivity : AppCompatActivity() {

    private lateinit var bind : ActivityCadastroBinding
    val viewModel by viewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(bind.root)

        onBackPressedDispatcher.addCallback(this){
            finish()
        }

        viewModel.usernameCriado.observe(this, {
            if (it) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                showMsg("Username indisponível, escolha outro.")
            }
        })


        bind.btnCadastrar.setOnClickListener {
            getDataFields()
        }

    }

    fun getDataFields(){
        val email = bind.edEmailCad.text.toString()
        val password = bind.edPasswordCad.text.toString()
        val user = bind.edUserCad.text.toString()
        if(!email.isEmpty() && !password.isEmpty() && !user.isEmpty()) sendDataEmailPwd(email, password, user)
        else showMsg("Preencha todos os campos!")
    }

    fun sendDataEmailPwd(email : String, pwd : String, user : String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pwd)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser: FirebaseUser = task.result?.user!!
                    val email = firebaseUser.email.toString()
                    viewModel.createConfigurationForUser(email)
                    viewModel.criarUsername(user)
                } else {
                    showMsg(task.exception.toString())
                }
            }
    }

    fun showMsg(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}