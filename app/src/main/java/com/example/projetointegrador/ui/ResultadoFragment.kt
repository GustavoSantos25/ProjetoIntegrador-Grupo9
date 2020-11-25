package com.example.projetointegrador.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.R
import kotlinx.android.synthetic.main.fragment_resultado.*
import kotlinx.android.synthetic.main.fragment_resultado.view.*

class ResultadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_resultado, container, false)

        view.btnTelaInicialResultado.setOnClickListener {
            findNavController().navigate(R.id.action_resultadoFragment_to_homeVPFragment)
        }

        return view
    }
}