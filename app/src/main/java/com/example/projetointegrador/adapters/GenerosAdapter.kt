package com.example.projetointegrador.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Genero

class GenerosAdapter(
    private val listaGeneros: ArrayList<Genero>,
) : RecyclerView.Adapter<GenerosAdapter.GenerosViewHolder>() {

    inner class GenerosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var ivGenero: ImageView = itemView.findViewById(R.id.ivGenero)
        var tvNomeGenero: TextView = itemView.findViewById(R.id.tvNomeGenero)

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenerosViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_genero, parent, false)
        return GenerosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GenerosViewHolder, position: Int) {
        val genero = listaGeneros[position]

        holder.ivGenero.setImageResource(genero.imagem)
        holder.tvNomeGenero.text = genero.nome
    }

    override fun getItemCount() = listaGeneros.size

    fun addAll(list : ArrayList<Genero>) = listaGeneros.addAll(list)
}