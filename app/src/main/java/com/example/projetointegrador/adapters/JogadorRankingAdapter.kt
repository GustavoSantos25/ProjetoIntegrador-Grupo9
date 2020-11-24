package com.example.projetointegrador.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Jogador

class JogadorRankingAdapter(private val listJogadores : ArrayList<Jogador>, val listener : OnClickJogadorListener) : RecyclerView.Adapter<JogadorRankingAdapter.JogadorViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JogadorRankingAdapter.JogadorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_jogador, parent, false)
        return JogadorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JogadorRankingAdapter.JogadorViewHolder, position: Int) {
        var jogador = listJogadores[position]
        holder.civAvatarRanking.setImageResource(jogador.imgAvatar)
        holder.tvNomeJogador.text = jogador.nome
        holder.tvAcertosRanking.text = jogador.acertos
    }

    override fun getItemCount(): Int = listJogadores.size

    interface OnClickJogadorListener{
        fun onClickJogador(position: Int)
    }

    inner class JogadorViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var tvNomeJogador: TextView = itemView.findViewById(R.id.tvNomeRanking)
        var civAvatarRanking: ImageView = itemView.findViewById(R.id.civAvatarRanking)
        var tvAcertosRanking: TextView = itemView.findViewById(R.id.tvAcertosRanking)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onClickJogador(position)
        }
    }

}