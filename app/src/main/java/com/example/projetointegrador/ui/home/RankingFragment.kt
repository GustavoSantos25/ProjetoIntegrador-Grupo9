package com.example.projetointegrador.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.JogadorRankingAdapter
import com.example.projetointegrador.adapters.RankingAdapter
import com.example.projetointegrador.domain.Jogador
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_pergunta.view.*
import kotlinx.android.synthetic.main.fragment_ranking.view.*


class RankingFragment : Fragment() {

    private val listRankings = ArrayList<ArrayList<Jogador>>()
    lateinit var adapter : RankingAdapter
    val viewModel by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_rankingFragment_to_homeVPFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_ranking, container, false)
        view.toolbarRank.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_rankingFragment_to_homeVPFragment)
        }
        adapter = RankingAdapter(view.context, listRankings)
//        viewModel.popPagesRanking()
        viewModel.pagesRanking.observe(viewLifecycleOwner, {
            adapter.addAll(it)
        })

        view.toolbarRank.title = "Ranking"
        view.toolbarRank.setTitleTextColor(resources.getColor(R.color.black))


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




}