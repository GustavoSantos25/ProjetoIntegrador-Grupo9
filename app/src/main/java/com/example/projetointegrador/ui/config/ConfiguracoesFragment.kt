package com.example.projetointegrador.ui.config

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentConfiguracoesBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.LoginActivity
import com.example.projetointegrador.ui.MainViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener


class ConfiguracoesFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }
    private lateinit var bind: FragmentConfiguracoesBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_configuracoes, container, false)


        bind = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_configuracoes,
            container,
            false
        )

        bind.tvGenerosFavoritos.setOnClickListener {
            generosDialog()
        }

        viewModel.configuracoes.observe(viewLifecycleOwner, {
            val config = it

            bind.scNotificacao.isChecked = config.notificacoes
            bind.scVibrar.isChecked = config.vibrar
            bind.tvEmailConfig.text = config.email

        })

        bind.scVibrar.setOnClickListener{
            viewModel.updateConfigurações(bind.scVibrar.isChecked, "vibrar")
        }

        bind.scNotificacao.setOnClickListener {
            viewModel.updateConfigurações(bind.scNotificacao.isChecked, "notificação")
        }

        bind.swGoogleAccountConnection.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                revokeAccess()
                val intent = Intent(this.requireActivity(), LoginActivity::class.java)
                startActivity(intent)
            }
        }

        return bind.root
    }

    private fun revokeAccess() {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this.requireActivity(), gso)
        googleSignInClient.revokeAccess()
        /*
        googleSignInClient.revokeAccess().addOnCompleteListener(this, OnCompleteListener<Void?> {
                // ...
            })
        googleSignInClient.revokeAccess().addOnCompleteListener(this, OnCompleteListener<Void?>{

        })
         */
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