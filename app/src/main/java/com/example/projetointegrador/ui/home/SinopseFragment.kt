package com.example.projetointegrador.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Filme
import com.example.projetointegrador.services.DBRepository
import com.example.projetointegrador.services.Repository
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_sinopse.view.*

class SinopseFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_sinopseFragment_to_homeVPFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_sinopse, container, false)


        view.toolbarSinopse.setTitleTextColor(resources.getColor(R.color.black))
        view.toolbarSinopse.title = "Sinopse"

        val filmeSinopse = viewModel.filmeSugestion.value!!
        val crewSinopse = viewModel.crewSugestion.value
        Glide.with(view.context).asBitmap()
            .load("https://image.tmdb.org/t/p/w500/"+ filmeSinopse.poster_path)
            .into(view.ivCapaSinopse)

        view.tvTitleSinopse.text = filmeSinopse.title
        view.tvDirSinopse.text = "Diretor: ${crewSinopse!!.crew.find { it.job == "Director" }!!.name}"
        view.tvSinopse.text = filmeSinopse.overview



        view.toolbarSinopse.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_sinopseFragment_to_homeVPFragment)
        }


        return view
    }


}