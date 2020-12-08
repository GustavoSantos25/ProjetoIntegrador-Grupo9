package com.example.projetointegrador.ui.home

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Filme
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_modos.view.*
import kotlinx.android.synthetic.main.icon_plus_appname.view.*


class HomeFragment : Fragment() {

    val viewModel by activityViewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    lateinit var filmeCard : Filme


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)
        view.btn_ranking.setOnClickListener {
            findNavController().navigate(R.id.action_homeVPFragment_to_rankingFragment)
        }

        viewModel.getFilmeSugestion()
        viewModel.filmeSugestion.observe(viewLifecycleOwner, {
            filmeCard = it
            Glide.with(view.context).asBitmap()
                .load("https://image.tmdb.org/t/p/w500/"+ filmeCard.poster_path)
                .into(view.ivCardHome)

            view.tvTitleFilmeSus.text = filmeCard.title
        })


        view.ivCardHome.setOnClickListener {
            findNavController().navigate(R.id.action_homeVPFragment_to_sinopseFragment)
        }
        view.ivAppName.setImageResource(R.drawable.icon_cinefilos)

        view.btnJogar.setOnClickListener {
            generosDialog()
        }
        view.btn_help.setOnClickListener{
            findNavController().navigate(R.id.action_homeVPFragment_to_ajudaFragment)
        }

        return view
    }

    private lateinit var alertDialog: AlertDialog

    private fun generosDialog() {
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.fragment_modos, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create();
        alertDialog.show()
        dialogView.llTimeLimit.setOnClickListener {
            findNavController().navigate(R.id.action_homeVPFragment_to_perguntaFragment)
            alertDialog.cancel()
        }
    }
}