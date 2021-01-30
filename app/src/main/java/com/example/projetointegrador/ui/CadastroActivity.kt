package com.example.projetointegrador.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.TextView
import androidx.activity.addCallback
import androidx.activity.viewModels
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.ActivityCadastroBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
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

        val extras = intent.extras
        var email = ""
        if(extras != null){
            email = extras.getString("Email").toString()
            bind.edEmailCad.setText(email, TextView.BufferType.EDITABLE)
            bind.edEmailCad.isEnabled = false
        }


        bind.btnCadastrar.setOnClickListener {
            viewModel.createConfigurationForUser(bind.edEmailCad.text.toString())
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", bind.edEmailCad.text.toString())
            startActivity(intent)
        }

    }
}