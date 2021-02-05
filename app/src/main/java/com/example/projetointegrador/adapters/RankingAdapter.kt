package com.example.projetointegrador.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Jogador
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_ranking.*
import kotlinx.android.synthetic.main.list_pager_ranking.view.*

class RankingAdapter(
    private val context: Context,
    private val viewModel: MainViewModel,
    private var listRanking: ArrayList<ArrayList<Jogador>>
) :
    PagerAdapter(), JogadorRankingAdapter.OnClickJogadorListener {

    var listTitles = arrayListOf("SOBREVIVÊNCIA", "TIME LIMIT")

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view =
            LayoutInflater.from(context).inflate(R.layout.list_pager_ranking, container, false)
        val ranking = listRanking[position]

        val adapter = JogadorRankingAdapter(ranking, position, context,viewModel, this)

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

    override fun getPageTitle(position: Int): CharSequence {
        return listTitles[position]
    }

    fun addAll(list : ArrayList<ArrayList<Jogador>>){
        listRanking = list
        notifyDataSetChanged()
    }

    override fun onClickJogador(position: Int) {

    }
}