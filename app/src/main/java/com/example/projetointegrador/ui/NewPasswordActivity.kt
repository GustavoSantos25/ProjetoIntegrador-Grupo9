package com.example.projetointegrador.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.ActivityLoginBinding
import com.example.projetointegrador.databinding.ActivityNewPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class NewPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRecoverPwd.setOnClickListener {
            FirebaseAuth.getInstance().sendPasswordResetEmail(binding.edRecoverPwd.text.toString())
            Toast.makeText(this, "Email para recuperaçãod de senha enviado!", Toast.LENGTH_LONG).show()
        }


    }
}