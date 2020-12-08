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
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.GenerosAdapter
import com.example.projetointegrador.domain.Genero
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_perfil_pessoal.view.*

class PerfilFragment : Fragment() {

    var listGeneros = ArrayList<Genero>()
    var adapter = GenerosAdapter(listGeneros)
    val viewModel by activityViewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_perfil_pessoal, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvGenerosPessoal)
        viewModel.popListGeneros()
        viewModel.listGeneros.observe(viewLifecycleOwner, {
            adapter.addAll(it)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        view.tvBio.setOnClickListener {
            showCustomDialog()
        }

        return view
    }

    private lateinit var alertDialog: AlertDialog

    private fun showCustomDialog() {
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.dialogue_editar_bio, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        val botaoSalvar = dialogView.findViewById<AppCompatButton>(R.id.btnSalvarBio)

        botaoSalvar.setOnClickListener {
            alertDialog.hide()
        }

        alertDialog = dialogBuilder.create();
        alertDialog.show()
    }

}