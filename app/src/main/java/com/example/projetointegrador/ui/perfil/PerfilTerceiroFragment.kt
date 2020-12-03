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
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.GenerosAdapter
import com.example.projetointegrador.domain.Genero
import kotlinx.android.synthetic.main.fragment_perfil_pessoal.view.*

class PerfilTerceiroFragment : Fragment() {

    val listaGeneros = getAllGeneros()
    var adapter = GenerosAdapter(listaGeneros)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_perfil_terceiro, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvGenerosTerceiro)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        return view
    }

    private fun getAllGeneros() = arrayListOf(
        Genero("Ação", R.drawable.placeholder_genero),
        Genero("Sci-Fi", R.drawable.scifi),
        Genero("Comédia", R.drawable.comedia),
        Genero("Terror", R.drawable.terror)
    )
}