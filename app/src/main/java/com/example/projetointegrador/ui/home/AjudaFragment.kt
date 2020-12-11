package com.example.projetointegrador.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.R
import kotlinx.android.synthetic.main.fragment_ajuda.view.*


class AjudaFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_ajudaFragment_to_homeVPFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater!!.inflate(R.layout.fragment_ajuda, container, false)
        view.toolbarAjuda.title = "Ajuda"
        view.toolbarAjuda.setTitleTextColor(resources.getColor(R.color.black))
        view.toolbarAjuda.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_ajudaFragment_to_homeVPFragment)
        }
        return view
    }


}