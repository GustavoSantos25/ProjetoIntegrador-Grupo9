package com.example.projetointegrador.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.projetointegrador.R
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.services.DBRepositoryImplementation
import com.example.projetointegrador.services.dbApp
import com.example.projetointegrador.services.dbRepository


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}