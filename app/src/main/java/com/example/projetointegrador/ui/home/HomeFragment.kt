package com.example.projetointegrador.ui.home

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_modos.view.*
import kotlinx.android.synthetic.main.icon_plus_appname.view.*


class HomeFragment : Fragment() {


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
        view.ivCardHome.setImageResource(R.drawable.img_card)
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