package com.example.projetointegrador.ui.config

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentConfiguracoesBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.gso
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_configuracoes.*
import kotlinx.android.synthetic.main.fragment_configuracoes.view.*

class ConfiguracoesFragment : Fragment() {


    private val viewModel by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }
    private lateinit var bind: FragmentConfiguracoesBinding

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

        bind.scFacebook.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            LoginManager.getInstance().logOut()
            findNavController().navigate(R.id.action_homeVPFragment_to_loginActivity)
        }

        bind.scGoogle.setOnClickListener {
            val gsic = GoogleSignIn.getClient(this.requireActivity(), gso)
            gsic.signOut()
            findNavController().navigate(R.id.action_homeVPFragment_to_loginActivity)
        }

        viewModel.facebookIsLogged.observe(viewLifecycleOwner, {
            bind.scFacebook.isChecked = it
        })

        viewModel.googleIsLogged.observe(viewLifecycleOwner, {
            bind.scGoogle.isChecked = it
        })



        return bind.root
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