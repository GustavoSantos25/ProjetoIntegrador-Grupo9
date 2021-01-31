package com.example.projetointegrador.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository


class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.updateLastMovieId()

        viewModel.initializeOfflineTemplates()

        val extras = intent.extras
        var email = ""

        if (extras != null) {
            email = extras.getString("email")!!
        }

        viewModel.getConfigurationForUser(email)

        navController = findNavController(R.id.navHostFragmentHome)

    }

    override fun onBackPressed() {
        if (podeVoltar()) {
            super.onBackPressed()
        }
    }

    //Impedir que o usuário volte para a tela anterior quando estiver na tela de resultado
    private fun podeVoltar(): Boolean {
        return when (navController.currentDestination?.id) {
            R.id.resultadoFragment -> false
            else -> true
        }
    }
}