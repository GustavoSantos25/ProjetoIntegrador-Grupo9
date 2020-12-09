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
import com.example.projetointegrador.services.repository
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_ranking.*

class HomeActivity : AppCompatActivity() {

      private lateinit var navController: NavController
      val viewModel by viewModels<MainViewModel>{
          object : ViewModelProvider.Factory{
              override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                  return MainViewModel(repository) as T
              }
          }
      }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.updateLastMovieId()

        navController = findNavController(R.id.navHostFragmentHome)
<<<<<<< HEAD

        viewModel.getFilmeSugestion()

=======
>>>>>>> 34aaadc6037df4981967cb4bb0f51085aefed579
    }
}