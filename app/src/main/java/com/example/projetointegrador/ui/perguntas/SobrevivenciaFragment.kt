package com.example.projetointegrador.ui.perguntas

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentSobrevivenciaBinding
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.custom_dialog_acerto.view.*
import kotlinx.android.synthetic.main.custom_dialog_erro.view.*

class SobrevivenciaFragment : Fragment() {

    private lateinit var binding: FragmentSobrevivenciaBinding
    private lateinit var alertDialog: AlertDialog
    private lateinit var progressView: ViewGroup
    private var progressoVisivel = false

    private val model by activityViewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_sobrevivenciaFragment_to_homeVPFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sobrevivencia,
            container,
            false
        )

        model.gerarPerguntaAleatoria()

        model.carregandoPergunta.observe(viewLifecycleOwner, {
            if (model.carregandoPergunta.value == true) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
        })

        model.pergunta.observe(viewLifecycleOwner, {
            binding.tvPerguntaSobrevivencia.text = model.pergunta.value?.enunciado
            popAlternativas()
        })

        binding.btnPrimeiraRespostaSobrevivencia.setOnClickListener {
            if (binding.btnPrimeiraRespostaSobrevivencia.text == model.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.btnSegundaRespostaSobrevivencia.setOnClickListener {
            if (binding.btnSegundaRespostaSobrevivencia.text == model.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.btnTerceiraRespostaSobrevivencia.setOnClickListener {
            if (binding.btnTerceiraRespostaSobrevivencia.text == model.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.btnQuartaRespostaSobrevivencia.setOnClickListener {
            if (binding.btnQuartaRespostaSobrevivencia.text == model.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.tvRecorde.text = model.recordeSobrevivencia.value.toString()

        model.acertos.observe(viewLifecycleOwner, {

            binding.tvQtdeAcertos.text = it.toString()

            if (model.novoRecorde("sobrevivencia")) {
                binding.tvRecorde.text = it.toString()
                binding.tvRecorde.setTextColor(ContextCompat.getColor(requireContext(), R.color.verdePositivo))
                binding.tvRecordeString.setTextColor(ContextCompat.getColor(requireContext(), R.color.verdePositivo))
            }
        })

        return binding.root
    }

    fun onAcerto() {
        val qtdAcertos = model.onAcerto()
        binding.tvQtdeAcertos.text = qtdAcertos.toString()
        binding.tvAcertosString.text = model.acertoSingularOuPlural()

        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.custom_dialog_acerto, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create();
        alertDialog.show()
        dialogView.btnOkAcerto.setOnClickListener {
            alertDialog.cancel()
            onFecharDialogAcerto()
        }
    }

    fun onErro() {

        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.custom_dialog_erro, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create();
        alertDialog.show()
        dialogView.btnOkErro.setOnClickListener {
            alertDialog.cancel()
            findNavController().navigate(R.id.action_sobrevivenciaFragment_to_resultadoFragment)
        }
    }

    //Gerar próxima pergunta
    private fun onFecharDialogAcerto() {
        model.gerarPerguntaAleatoria()
    }

    fun popAlternativas() {
        model.popAlternativas(
            arrayOf(
                binding.btnPrimeiraRespostaSobrevivencia,
                binding.btnSegundaRespostaSobrevivencia,
                binding.btnTerceiraRespostaSobrevivencia,
                binding.btnQuartaRespostaSobrevivencia
            )
        )
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