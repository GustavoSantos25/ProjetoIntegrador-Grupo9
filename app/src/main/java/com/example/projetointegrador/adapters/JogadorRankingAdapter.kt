package com.example.projetointegrador.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Jogador
import com.example.projetointegrador.ui.MainViewModel

class JogadorRankingAdapter(
    private val listJogadores: ArrayList<Jogador>,
    private val viewPagerPosition: Int,
    val context: Context,
    val viewModel: MainViewModel,
    val listener: OnClickJogadorListener
) : RecyclerView.Adapter<JogadorRankingAdapter.JogadorViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JogadorRankingAdapter.JogadorViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_jogador, parent, false)
        return JogadorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JogadorRankingAdapter.JogadorViewHolder, position: Int) {
        val jogador = listJogadores[position]

        if (jogador.urlAvatar.isNotEmpty()) {
            Glide.with(context).load(jogador.urlAvatar).into(holder.civAvatarRanking)
        }

        holder.tvNomeJogador.text = jogador.userName

        if (viewPagerPosition == 0) {
            holder.tvAcertosRanking.text = jogador.recordeSobrevivencia.toString()
        } else {
            holder.tvAcertosRanking.text = jogador.recordeTimeLimit.toString()
        }

        if (holder.tvAcertosRanking.text.toString().toInt() == 0) {
            holder.tvAcertosString.text = "Acerto"
        }

        holder.itemView.setOnClickListener { view ->
            viewModel.jogadorClicado = jogador
            viewModel.goToPerfilTerceiro()
        }
    }

    override fun getItemCount(): Int = listJogadores.size

    interface OnClickJogadorListener {
        fun onClickJogador(position: Int)
    }

    inner class JogadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),

        View.OnClickListener {
        var tvNomeJogador: TextView = itemView.findViewById(R.id.tvNomeRanking)
        var civAvatarRanking: ImageView = itemView.findViewById(R.id.civAvatarRanking)
        var tvAcertosRanking: TextView = itemView.findViewById(R.id.tvAcertosRanking)
        val tvAcertosString: TextView = itemView.findViewById(R.id.tvAcertosString)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.onClickJogador(position)
        }
    }
}
