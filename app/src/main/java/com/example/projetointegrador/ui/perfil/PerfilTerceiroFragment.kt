package com.example.projetointegrador.ui.perfil

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.GenerosAdapter
import com.example.projetointegrador.databinding.FragmentPerfilPessoalBinding
import com.example.projetointegrador.databinding.FragmentPerfilTerceiroBinding
import com.example.projetointegrador.domain.Genero
import com.example.projetointegrador.domain.Jogador
import com.example.projetointegrador.services.EventObserver
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_ajuda.view.*
import kotlinx.android.synthetic.main.fragment_perfil_pessoal.view.*

class PerfilTerceiroFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding: FragmentPerfilTerceiroBinding
    val listaGeneros = ArrayList<Genero>()
    var adapter = GenerosAdapter(listaGeneros)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requireActivity().onBackPressedDispatcher.addCallback(this){
//            viewModel.goToRanking()
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_perfil_terceiro,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val jogadorClicado: Jogador = viewModel.jogadorClicado

        if (jogadorClicado.urlCapa.isNotEmpty()) {
            Glide.with(binding.root).load(jogadorClicado.urlCapa).into(binding.ivCapa)
        }

        if (jogadorClicado.urlAvatar.isNotEmpty()) {
            Glide.with(binding.root).load(jogadorClicado.urlAvatar).into(binding.civAvatar)
        }

        binding.toolbarPerfilTerceiro.setNavigationOnClickListener {
            viewModel.goToRanking()
        }

        binding.tvNomePerfil.text = jogadorClicado.userName

        if (jogadorClicado.bio.isNotEmpty()) {
            binding.tvBio.text = jogadorClicado.bio
        } else {
            binding.tvBio.text = getString(R.string.terceiroSemBio)
        }

        binding.tvAcertosTimeLimit.text = jogadorClicado.recordeTimeLimit.toString()
        binding.tvAcertosSobrevivencia.text = jogadorClicado.recordeSobrevivencia.toString()

        val recyclerView = binding.rvGenerosTerceiro
        viewModel.listGeneros.observe(viewLifecycleOwner, {
            listaGeneros.addAll(it)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        return binding.root
    }

    private fun getAllGeneros() = arrayListOf(
        Genero(1, "Ação", R.drawable.placeholder_genero),
        Genero(2, "Sci-Fi", R.drawable.scifi),
        Genero(3, "Comédia", R.drawable.comedia),
        Genero(4, "Terror", R.drawable.terror)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        viewModel.navigateScreen.observe(viewLifecycleOwner, EventObserver {
            navController.navigate(it)
        })
    }
}