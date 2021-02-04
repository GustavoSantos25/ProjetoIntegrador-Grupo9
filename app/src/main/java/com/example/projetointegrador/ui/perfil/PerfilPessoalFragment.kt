package com.example.projetointegrador.ui.perfil

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.WhichButton
import com.afollestad.materialdialogs.actions.setActionButtonEnabled
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import com.bumptech.glide.Glide
import com.example.projetointegrador.MainViewModelFactory
import com.example.projetointegrador.R
import com.example.projetointegrador.adapters.GenerosAdapter
import com.example.projetointegrador.databinding.FragmentPerfilPessoalBinding
import com.example.projetointegrador.domain.Genero
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_perfil_pessoal.view.*

class PerfilPessoalFragment : Fragment() {

    private lateinit var binding: FragmentPerfilPessoalBinding
    private lateinit var alertImg: AlertDialog
    private lateinit var storageReference: StorageReference
    var listGeneros = ArrayList<Genero>()
    var adapter = GenerosAdapter(listGeneros)

    private val CODE_IMG_CAPA = 1000
    private val COD_IMG_AVATAR = 1001

    val viewModel by activityViewModels<MainViewModel>{
        MainViewModelFactory(repository, dbRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        alertImg = SpotsDialog.Builder().setContext(context).build()

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_perfil_pessoal,
            container,
            false
        )

        val recyclerView = binding.rvGenerosPessoal
        viewModel.popListGeneros()
        viewModel.listGeneros.observe(viewLifecycleOwner, {
            adapter.addAll(it)
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        viewModel.jogadorLogado.observe(viewLifecycleOwner, { jogador ->

            if (jogador["urlAvatar"].toString() != "") {
                Glide.with(binding.root).load(jogador["urlAvatar"].toString()).into(binding.civAvatar)
            }

            if (jogador["urlCapa"].toString().isNotEmpty()) {
                Glide.with(binding.root).load(jogador["urlCapa"].toString()).into(binding.ivCapa)
            }

            binding.tvNomePerfil.text = jogador["userName"].toString()

            if (jogador["bio"].toString().isNotEmpty()) {
                binding.tvBio.text = jogador["bio"].toString()
            }

            binding.tvAcertosTimeLimit.text = jogador["recordeTimeLimit"].toString()
            binding.tvAcertosSobrevivencia.text = jogador["recordeSobrevivencia"].toString()
        })

        binding.ibFotoCapa.setOnClickListener {
            setIntentCapa()
        }

        binding.civAvatar.setOnClickListener {
            setIntentAvatar()
        }

        binding.tvBio.setOnClickListener {
            editarBio()
        }

        return binding.root
    }

    fun setIntentCapa() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "captura_imagem"), CODE_IMG_CAPA)
    }

    fun setIntentAvatar() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "captura_imagem"), COD_IMG_AVATAR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null && data.data != null) {

            storageReference = FirebaseStorage.getInstance().getReference(data.dataString!!)
            alertImg.show()

            val uploadTask = storageReference.putFile(data.data!!)

            if (requestCode == CODE_IMG_CAPA) {
                uploadTask.continueWithTask {
                    storageReference.downloadUrl
                }.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        viewModel.deleteCapaAntiga()
                        val urlCapa = task.result.toString()
                        viewModel.updateCapa(urlCapa)
                        Glide.with(binding.root).load(urlCapa).into(binding.ivCapa)
                    }
                }
            } else if (requestCode == COD_IMG_AVATAR) {
                uploadTask.continueWithTask {
                    storageReference.downloadUrl
                }.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        viewModel.deleteAvatarAntigo()
                        val urlAvatar = task.result.toString()
                        viewModel.updateAvatar(urlAvatar)
                        Glide.with(binding.root).load(urlAvatar).into(binding.civAvatar)
                    }
                }
            }

            viewModel.getDadosJogadorLogado()

            alertImg.dismiss()
        }
    }

    fun editarBio() {

        val dialogBio = MaterialDialog(requireContext())
        var textoBio = binding.tvBio.text

        if (textoBio == getString(R.string.clique_aqui_para_editar_sua_bio)) {
            textoBio = ""
        }

        dialogBio.show {

            input(maxLength = 100, prefill = textoBio) { dialog, text ->

                val inputField = dialog.getInputField()
                val bio: String = inputField.text.toString()
                val bioVazia = bio.isEmpty()

                if (!bioVazia) {
                    viewModel.updateBio(bio)
                    viewModel.getDadosJogadorLogado()
                    Toast.makeText(context, "Bio atualizada com sucesso!", Toast.LENGTH_SHORT).show()
                }

                inputField.error = if (bioVazia) "Escreva algo" else null

                dialog.setActionButtonEnabled(WhichButton.POSITIVE, !bioVazia)
            }

            positiveButton(R.string.salvar)
        }
    }
}