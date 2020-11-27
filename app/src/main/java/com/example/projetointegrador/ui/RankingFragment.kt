package com.example.projetointegrador.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.JogadorRankingAdapter
import com.example.projetointegrador.adapters.RankingAdapter
import com.example.projetointegrador.domain.Jogador
import kotlinx.android.synthetic.main.fragment_pergunta.view.*
import kotlinx.android.synthetic.main.fragment_ranking.view.*


class RankingFragment : Fragment() {
    private val listRankings  : ArrayList<ArrayList<Jogador>> = arrayListOf(getAllJogadoresRank1(), getAllJogadoresRank2())
    lateinit var adapter : RankingAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_ranking, container, false)
        view.toolbarRank.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_rankingFragment_to_homeVPFragment)
        }
        view.toolbarRank.setTitle("Ranking")
        view.toolbarRank.setTitleTextColor(resources.getColor(R.color.black))
        adapter = RankingAdapter(view.context, listRankings)
        view.vpRanking.adapter = adapter
        view.vpRanking.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }


        })
        view.tl_ranking.setupWithViewPager(view.vpRanking)
        return view
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



}