package com.example.projetointegrador

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegrador.services.DBRepository
import com.example.projetointegrador.services.Repository
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.example.projetointegrador.ui.MainViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory(repository: Repository, dbRepository: DBRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository, dbRepository) as T
        }
        throw IllegalArgumentException("Classe viewmodel desconhecida")
    }
}

