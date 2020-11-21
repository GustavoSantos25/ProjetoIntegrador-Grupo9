package com.example.projetointegrador.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Jogador
import kotlinx.android.synthetic.main.list_pager_ranking.view.*

class RankingAdapter(private val context : Context, private val listRanking : ArrayList<ArrayList<Jogador>>) : PagerAdapter(), JogadorRankingAdapter.OnClickJogadorListener {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.list_pager_ranking, container, false)
        var ranking = listRanking[position]

        when(position){
            1 -> ranking = getAllJogadoresRank1()
            2 -> ranking = getAllJogadoresRank2()
        }

        val adapter = JogadorRankingAdapter(ranking, this)

        view.rvRanking.adapter = adapter
        view.rvRanking.layoutManager = LinearLayoutManager(context)
        view.rvRanking.setHasFixedSize(true)

        container.addView(view)

        return view
    }

    override fun getCount(): Int = listRanking.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


    fun getAllJogadoresRank1() = arrayListOf(
        Jogador("Jogador 1", "10 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 2", "9 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 3", "8 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 4", "7 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 5", "6 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 6", "5 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 7", "4 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 8", "3 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 9", "2 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 10", "1 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
    )

    fun getAllJogadoresRank2() = arrayListOf(
        Jogador("Jogador 1", "10 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 2", "9 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 3", "8 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 4", "7 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 5", "6 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 6", "5 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 7", "4 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 8", "3 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 9", "2 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 10", "1 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
    )

    override fun onClickJogador(position: Int) {
        Toast.makeText(context, "RANKING $position", Toast.LENGTH_SHORT).show()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "MODO ${(position + 1)}"
    }

}