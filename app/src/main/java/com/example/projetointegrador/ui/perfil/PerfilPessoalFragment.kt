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
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    ): View? {

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
            showCustomDialog()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()


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
                        val urlAvatar = task.result.toString()
                        viewModel.updateAvatar(urlAvatar)
                        Glide.with(binding.root).load(urlAvatar).into(binding.civAvatar)
                    }
                }
            }

            alertImg.dismiss()
        }
    }

    private lateinit var alertDialog: AlertDialog

    private fun showCustomDialog() {
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.dialogue_editar_bio, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)

        val botaoSalvar = dialogView.findViewById<AppCompatButton>(R.id.btnSalvarBio)

        botaoSalvar.setOnClickListener {
            alertDialog.hide()
        }

        alertDialog = dialogBuilder.create();
        alertDialog.show()
    }

}