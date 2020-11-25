package com.example.projetointegrador.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.R
import kotlinx.android.synthetic.main.fragment_sinopse.view.*

class SinopseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_sinopse, container, false)

        view.toolbarSinopse.title = "Sugestão do dia"
        view.toolbarSinopse.setTitleTextColor(resources.getColor(R.color.black))
        view.ivCapaSinopse.setImageResource(R.drawable.capa_killbill)

        view.toolbarSinopse.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_sinopseFragment_to_homeVPFragment)
        }


        return view
    }


}