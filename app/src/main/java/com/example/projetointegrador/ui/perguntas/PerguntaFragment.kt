package com.example.projetointegrador.ui.perguntas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Pergunta
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_pergunta.*
import kotlinx.android.synthetic.main.fragment_pergunta.view.*
import kotlinx.android.synthetic.main.toolbar_quiz.*
import kotlinx.android.synthetic.main.toolbar_quiz.view.*

class PerguntaFragment : Fragment() {

    private lateinit var model: MainViewModel
    val acertos = 0

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

        model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.generateRandomQuestion()

        model.pergunta.observe(viewLifecycleOwner, {

            val pergunta: Pergunta? = model.pergunta.value
            view.tvPergunta.text = pergunta?.enunciado

            view.toolbar_quiz.tvGeneroPergunta.text = it.genero

            model.popAlternativas(
                arrayOf(
                    view.btnPrimeiraResposta,
                    view.btnSegundaResposta,
                    view.btnTerceiraResposta,
                    view.btnQuartaResposta
                )
            )
        })

        model.updateTimer()
        model.timer.observe(viewLifecycleOwner, {
            view.timerQuestion.text = it
            if(it == "0:00") findNavController().navigate(R.id.action_perguntaFragment_to_resultadoFragment)
        })

        return view
    }


}