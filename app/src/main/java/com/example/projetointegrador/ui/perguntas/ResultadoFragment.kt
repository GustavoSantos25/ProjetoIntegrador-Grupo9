package com.example.projetointegrador.ui.perguntas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentResultadoBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_resultado.view.*

class ResultadoFragment : Fragment() {

    private lateinit var binding: FragmentResultadoBinding

    private val model by activityViewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_resultado,
            container,
            false
        )

        binding.tvQtdeAcertosResultado.text = model.acertos.value.toString()

        binding.btnTelaInicialResultado.setOnClickListener {
            findNavController().navigate(R.id.action_resultadoFragment_to_homeVPFragment)
        }

        model.verificarNovoRecorde()

        return binding.root
    }
}