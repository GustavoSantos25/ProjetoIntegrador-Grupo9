package com.example.projetointegrador.ui.config

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentConfiguracoesBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.notifications
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.LoginActivity
import com.example.projetointegrador.ui.MainViewModel
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging

class ConfiguracoesFragment : Fragment() {


    private val viewModel by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }
    private lateinit var binding: FragmentConfiguracoesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_configuracoes,
            container,
            false
        )

        binding.tvEmailConfig.text = FirebaseAuth.getInstance().currentUser!!.email.toString()

        binding.tvGenerosFavoritos.setOnClickListener {
            generosDialog()
        }

        viewModel.configuracoes.observe(viewLifecycleOwner, {
            val config = it

            binding.scNotificacao.isChecked = config.notificacoes
            notifications = config.notificacoes
            binding.scVibrar.isChecked = config.vibrar
        })

        binding.scVibrar.setOnClickListener{
            viewModel.updateConfiguracoes(binding.scVibrar.isChecked, "vibrar")
        }

        binding.scNotificacao.setOnClickListener {
            viewModel.updateConfiguracoes(binding.scNotificacao.isChecked, "notificação")

        }

        viewModel.jogadorLogado.observe(viewLifecycleOwner, { jogadorLogado ->
            binding.tvUsernameConfig.text = jogadorLogado["userName"].toString()
        })

        binding.llLogout.setOnClickListener {
            LoginManager.getInstance().logOut()
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        notifications = binding.scNotificacao.isChecked

        return binding.root
    }

    private lateinit var alertDialog: AlertDialog

    private fun generosDialog() {
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.dialogue_generos_favoritos, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create();
        alertDialog.show()
    }
}