package com.example.projetointegrador.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Jogador
import kotlinx.android.synthetic.main.list_pager_ranking.view.*

class RankingAdapter(
    private val context: Context,
    private val listRanking: ArrayList<ArrayList<Jogador>>
) :
    PagerAdapter(), JogadorRankingAdapter.OnClickJogadorListener {

    var listTitles = arrayListOf("SOBREVIVÊNCIA", "TIME LIMIT")

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var view =
            LayoutInflater.from(context).inflate(R.layout.list_pager_ranking, container, false)
        var ranking = listRanking[position]

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

    override fun onClickJogador(position: Int) {

//        Toast.makeText(context, "RANKING $position", Toast.LENGTH_SHORT).show()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return listTitles[position]
    }

    fun addAll(list : ArrayList<ArrayList<Jogador>>){
        listRanking.addAll(list)
        notifyDataSetChanged()
    }


}