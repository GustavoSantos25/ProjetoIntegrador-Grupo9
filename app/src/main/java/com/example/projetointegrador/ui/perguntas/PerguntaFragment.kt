package com.example.projetointegrador.ui.perguntas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentPerguntaBinding
import com.example.projetointegrador.domain.Pergunta
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_pergunta.*

class PerguntaFragment : Fragment() {

    private lateinit var binding: FragmentPerguntaBinding

    private lateinit var model: MainViewModel

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

        model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.gerarPerguntaAleatoria()

        model.pergunta.observe(viewLifecycleOwner, {

            val pergunta: Pergunta? = model.pergunta.value
            binding.tvPergunta.text = pergunta?.enunciado

//            model.atualizarGeneroToolbar(view.findViewById(R.id.toolbar_quiz))

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