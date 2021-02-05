package com.example.projetointegrador.ui.home

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Crew
import com.example.projetointegrador.domain.Filme
import com.example.projetointegrador.domain.ModosDeJogo
import com.example.projetointegrador.services.EventObserver
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_modos.view.*
import kotlinx.android.synthetic.main.icon_plus_appname.view.*
import java.lang.reflect.Field
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var navController: NavController
    lateinit var filmeCard: Filme
    lateinit var crewCard: Crew

    private val viewModel by activityViewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.btn_ranking.setOnClickListener {
            viewModel.goToRanking()
        }

        viewModel.jogadorLogado.observe(viewLifecycleOwner, {
            viewModel.getFilmeSugestion()
        })

        viewModel.carregandoCard.observe(viewLifecycleOwner, {
            if(it){
                view.pb_cardSugestao.visibility = View.VISIBLE
                view.ivCardHome.visibility = View.GONE
                view.ll_TitleDirSug.visibility = View.GONE
            }
            else{
                view.pb_cardSugestao.visibility = View.GONE
                view.ivCardHome.visibility = View.VISIBLE
                view.ll_TitleDirSug.visibility = View.VISIBLE
            }
        })

        viewModel.filmeSugestion.observe(viewLifecycleOwner, { it ->
            filmeCard = it
            Glide.with(view.context).asBitmap()
                .load("https://image.tmdb.org/t/p/w500/" + filmeCard.backdrop_path)
                .into(view.ivCardHome)
            view.tvTitleFilmeSus.text = filmeCard.title
            viewModel.crewSugestion.observe(viewLifecycleOwner, {
                crewCard = it
                view.tvNomeDir.text =
                    "Diretor: ${crewCard.crew.find { it.job == "Director" }?.name}"
            })
        })

        view.ivCardHome.setOnClickListener {
            viewModel.goToSinopse()
        }

        view.ivAppName.setImageResource(R.drawable.icon_cinefilos)

        view.btnJogar.setOnClickListener {
            generosDialog()
        }

        view.btn_help.setOnClickListener {
            viewModel.goToAjuda()
        }

        viewModel.getDadosJogadorLogado()

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
            viewModel.acertos.value = 0
            viewModel.modoDeJogo = ModosDeJogo.TIME_LIMIT
            viewModel.goToPergunta()
            alertDialog.cancel()
        }

        dialogView.llSurvival.setOnClickListener {
            viewModel.acertos.value = 0
            viewModel.modoDeJogo = ModosDeJogo.SOBREVIVENCIA
            viewModel.goToSobrevivencia()
            alertDialog.cancel()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        viewModel.navigateScreen.observe(viewLifecycleOwner, EventObserver {
            navController.navigate(it)
        })
    }
}