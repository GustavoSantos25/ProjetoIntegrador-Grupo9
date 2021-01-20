package com.example.projetointegrador.ui

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projetointegrador.R
import com.example.projetointegrador.dao.TemplateDAO
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.domain.Template
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.services.DBRepository
import com.example.projetointegrador.services.DBRepositoryImplementation
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_ranking.*

class HomeActivity : AppCompatActivity() {

      private lateinit var navController: NavController
      private lateinit var dbApp: AppDataBase
      private lateinit var dbRepository: DBRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initDB()
        dbRepository = DBRepositoryImplementation(dbApp.TemplateDAO(), dbApp.FilmeReplaceDAO(), dbApp.ConfiguracoesDAO())

        val viewModel by viewModels<MainViewModel>{
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(repository, dbRepository) as T
                }
            }
        }

        //viewModel.updateLastMovieId()
        viewModel.getFilmeSugestion()
        viewModel.initializeOfflineTemplates()

        navController = findNavController(R.id.navHostFragmentHome)

    }

    fun initDB() {
        dbApp = AppDataBase.invoke(this)
    }


}