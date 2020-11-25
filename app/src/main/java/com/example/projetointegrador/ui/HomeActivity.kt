package com.example.projetointegrador.ui

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projetointegrador.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_ranking.*

class HomeActivity : AppCompatActivity() {

//    private lateinit var navController: NavController
//    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        setSupportActionBar(toolbarRank)
//
//        navController = findNavController(R.id.navHostFragmentHome)
//
//        navController.addOnDestinationChangedListener { _, destination, arguments ->
//            when (destination.id) {
//                R.id.homeFragment -> {
//                    mudarCorDaToolbar(R.color.transparent)
//                }
//            }
//        }
//
//        setupActionBarWithNavController(navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
//
//    fun mudarCorDaToolbar(colorId: Int) {
//        supportActionBar!!.setBackgroundDrawable(
//            ColorDrawable(
//                ContextCompat.getColor(
//                    this,
//                    colorId
//                )
//            )
//        )
//    }
}