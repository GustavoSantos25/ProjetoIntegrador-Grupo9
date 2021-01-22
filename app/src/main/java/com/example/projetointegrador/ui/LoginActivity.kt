package com.example.projetointegrador.ui

import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
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
    }

    fun initDB() {
        dbApp = AppDataBase.invoke(this)
    }
}