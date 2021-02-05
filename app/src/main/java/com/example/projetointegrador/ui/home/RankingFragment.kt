package com.example.projetointegrador.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.JogadorRankingAdapter
import com.example.projetointegrador.adapters.RankingAdapter
import com.example.projetointegrador.databinding.FragmentRankingBinding
import com.example.projetointegrador.domain.Jogador
import com.example.projetointegrador.services.EventObserver
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_pergunta.view.*
import kotlinx.android.synthetic.main.fragment_ranking.*
import kotlinx.android.synthetic.main.fragment_ranking.view.*


class RankingFragment : Fragment(), JogadorRankingAdapter.OnClickJogadorListener {

    private lateinit var binding: FragmentRankingBinding
    private val listRankings = ArrayList<ArrayList<Jogador>>()
    private var progressoVisivel = false
    private lateinit var progressView: ViewGroup
    lateinit var adapter : RankingAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var navController: NavController
//    val viewModel by activityViewModels<MainViewModel>{
//        MainViewModelFactory(repository, dbRepository)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            viewModel.goToHome()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_ranking,
            container,
            false
        )

        binding.toolbarRank.setNavigationOnClickListener {
            viewModel.goToHome()
        }

        // Inflate the layout for this fragment
//        val view: View = inflater!!.inflate(R.layout.fragment_ranking, container, false)
//        view.toolbarRank.setNavigationOnClickListener {
//            viewModel.goToHome()
//        }

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        adapter = RankingAdapter(requireContext(), viewModel, listRankings)

        viewModel.getDadosJogadoresSobrevivencia()

        showProgressBar()

        viewModel.listJogadoresSobrevivencia.observe(viewLifecycleOwner, {
            viewModel.getDadosJogadoresTimeLimit()
        })

        viewModel.listJogadoresTimeLimit.observe(viewLifecycleOwner, {
            viewModel.popPagesRanking()
        })

        viewModel.pagesRanking.observe(viewLifecycleOwner, {
            adapter.addAll(it)
            hideProgressBar()
        })

        binding.toolbarRank.title = "Ranking"
        binding.toolbarRank.setTitleTextColor(resources.getColor(R.color.black))

        binding.vpRanking.adapter = adapter
        binding.vpRanking.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
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

        binding.tlRanking.setupWithViewPager(binding.vpRanking)
        return binding.root
    }

    override fun onClickJogador(position: Int) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        viewModel.navigateScreen.observe(viewLifecycleOwner, EventObserver {
            navController.navigate(it)
        })
    }

    private fun showProgressBar() {
        if (!progressoVisivel) {
            progressoVisivel = true
            progressView = layoutInflater.inflate(R.layout.progressbar_layout, null) as ViewGroup
            //Centralizar progress bar
            progressView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val view = binding.root
            val viewGroup: ViewGroup = view as ViewGroup
            viewGroup.addView(progressView)
        }
    }

    private fun hideProgressBar() {
        val view = binding.root
        val viewGroup: ViewGroup = view as ViewGroup
        viewGroup.removeView(progressView)
        progressoVisivel = false
    }
}