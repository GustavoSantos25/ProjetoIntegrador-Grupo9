package com.example.projetointegrador.ui.perguntas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.Pergunta
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_pergunta.*

class PerguntaFragment : Fragment() {

    private lateinit var model: MainViewModel
    val acertos = 0

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
            tvPergunta.text = pergunta?.enunciado

//            model.atualizarGeneroToolbar(view.findViewById(R.id.toolbar_quiz))

            model.popAlternativas(
                arrayOf(
                    btnPrimeiraResposta,
                    btnSegundaResposta,
                    btnTerceiraResposta,
                    btnQuartaResposta
                )
            )
        })

        return view
    }


}