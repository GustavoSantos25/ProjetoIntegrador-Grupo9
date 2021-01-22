package com.example.projetointegrador.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.domain.Configuracoes
import com.example.projetointegrador.services.DBRepositoryImplementation
import com.example.projetointegrador.services.dbApp
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import kotlinx.coroutines.coroutineScope


class HomeActivity : AppCompatActivity() {

      private lateinit var navController: NavController

      val viewModel by viewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
      }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initDB()
        dbRepository = DBRepositoryImplementation(
            dbApp.TemplateDAO(),
            dbApp.FilmeReplaceDAO(),
            dbApp.ConfiguracoesDAO()
        )



        //viewModel.updateLastMovieId()

        viewModel.initializeOfflineTemplates()

        val extras = intent.extras
        var email = ""

        if (extras != null) {
            email = extras.getString("email")!!
        }

        viewModel.atualizarEmailUser(email)
        viewModel.getConfigurationForUser(email)

        navController = findNavController(R.id.navHostFragmentHome)

    }

    fun initDB() {
        dbApp = AppDataBase.invoke(this)
    }


}