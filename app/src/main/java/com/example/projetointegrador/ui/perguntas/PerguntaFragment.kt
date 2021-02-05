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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.databinding.FragmentPerguntaBinding
import com.example.projetointegrador.services.EventObserver
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import kotlinx.android.synthetic.main.custom_dialog_acerto.view.*
import kotlinx.android.synthetic.main.custom_dialog_erro.view.*

class PerguntaFragment : Fragment() {

    private lateinit var binding: FragmentPerguntaBinding
    private lateinit var alertDialog: AlertDialog
    private lateinit var progressView: ViewGroup
    private lateinit var navController: NavController
    private var progressoVisivel = false

    private val viewModel by activityViewModels<MainViewModel> {
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.goToHome()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pergunta,
            container,
            false
        )

        viewModel.gerarPerguntaAleatoria()

        viewModel.carregandoPergunta.observe(viewLifecycleOwner, {
            if (viewModel.carregandoPergunta.value == true) {
                showProgressBar()
            } else {
                hideProgressBar()
                viewModel.startStopTimer()
            }
        })

        viewModel.pergunta.observe(viewLifecycleOwner, {
            binding.tvPergunta.text = viewModel.pergunta.value?.enunciado
            popAlternativas()
        })

        binding.btnPrimeiraResposta.setOnClickListener {
            if (binding.btnPrimeiraResposta.text == viewModel.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.btnSegundaResposta.setOnClickListener {
            if (binding.btnSegundaResposta.text == viewModel.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.btnTerceiraResposta.setOnClickListener {
            if (binding.btnTerceiraResposta.text == viewModel.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        binding.btnQuartaResposta.setOnClickListener {
            if (binding.btnQuartaResposta.text == viewModel.pergunta.value?.alternativaCerta) {
                onAcerto()
            } else {
                onErro()
            }
        }

        viewModel.updateTimer()
        viewModel.timer.observe(viewLifecycleOwner, {
            binding.timerQuestion.text = it
            if(it == "0:00") viewModel.goToResultado()
        })

        binding.tvRecorde.text = viewModel.recordeTimeLimit.value.toString()

        viewModel.acertos.observe(viewLifecycleOwner, {

            binding.tvQtdeAcertos.text = it.toString()

            if (viewModel.novoRecorde()) {
                binding.tvRecorde.text = it.toString()
                binding.tvRecorde.setTextColor(ContextCompat.getColor(requireContext(), R.color.verdePositivo))
                binding.tvRecordeString.setTextColor(ContextCompat.getColor(requireContext(), R.color.verdePositivo))
            }
        })

        return binding.root
    }

    fun onAcerto() {
        val qtdAcertos = viewModel.onAcerto()
        binding.tvQtdeAcertos.text = qtdAcertos.toString()
        binding.tvAcertosString.text = viewModel.acertoSingularOuPlural()

        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.custom_dialog_acerto, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create();
        alertDialog.show()
        dialogView.btnOkAcerto.setOnClickListener {
            alertDialog.cancel()
            viewModel.startStopTimer()
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
            viewModel.startStopTimer()
            onFecharDialogAcerto()
        }
    }

    //Gerar próxima pergunta
    private fun onFecharDialogAcerto() {
        viewModel.gerarPerguntaAleatoria()
    }

    fun popAlternativas() {
        viewModel.popAlternativas(
            arrayOf(
                binding.btnPrimeiraResposta,
                binding.btnSegundaResposta,
                binding.btnTerceiraResposta,
                binding.btnQuartaResposta
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        viewModel.navigateScreen.observe(viewLifecycleOwner, EventObserver {
            navController.navigate(it)
        })
    }
}