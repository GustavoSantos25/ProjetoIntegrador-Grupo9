package com.example.projetointegrador.ui.perguntas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.activity.addCallback

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentPerguntaBinding
import com.example.projetointegrador.domain.Pergunta
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_pergunta.*
import kotlinx.android.synthetic.main.fragment_pergunta.view.*
import kotlinx.android.synthetic.main.toolbar_quiz.*
import kotlinx.android.synthetic.main.toolbar_quiz.view.*

class PerguntaFragment : Fragment() {

    private lateinit var binding: FragmentPerguntaBinding

    private val model by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_perguntaFragment_to_homeVPFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_pergunta, container, false)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pergunta,
            container,
            false
        )

        model.gerarPerguntaAleatoria()

        model.pergunta.observe(viewLifecycleOwner, {

            val pergunta: Pergunta? = model.pergunta.value

            binding.tvPergunta.text = pergunta?.enunciado


           view.includeToolbarQuiz.tvGeneroPergunta.text = it.genero

            model.popAlternativas(
                arrayOf(
                    binding.btnPrimeiraResposta,
                    binding.btnSegundaResposta,
                    binding.btnTerceiraResposta,
                    binding.btnQuartaResposta

                )
            )
        })

        return binding.root

    }

    //Gerar próxima pergunta
    private fun onResposta() {
        model.gerarPerguntaAleatoria()
    }

}