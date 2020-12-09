package com.example.projetointegrador.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.*
import com.example.projetointegrador.services.Repository
import com.example.projetointegrador.services.repository
import kotlinx.coroutines.launch

class MainViewModel(repository: Repository) : ViewModel() {
    val listGeneros = MutableLiveData<ArrayList<Genero>>()
    val pagesRanking = MutableLiveData<ArrayList<ArrayList<Jogador>>>()
    val listGenres = MutableLiveData<Genres>()
    val filmeSugestion = MutableLiveData<Filme>()
    val crewSugestion = MutableLiveData<Crew>()

    fun popListGeneros(){
        viewModelScope.launch {
            listGeneros.value = getAllGeneros()
        }
    }

    fun popPagesRanking(){
        viewModelScope.launch {
            pagesRanking.value = arrayListOf(getAllJogadoresRank1(), getAllJogadoresRank2())
        }
    }

    fun popListGenres(){
        viewModelScope.launch {
            listGenres.value = repository.getGenerosRepo("2ae684da617a0a9eb2d4bd28815050e8")
        }
    }

    fun getFilmeSugestion(){
        viewModelScope.launch {
            filmeSugestion.value = repository.getFilmeSugestionRepo("2ae684da617a0a9eb2d4bd28815050e8", "pt-BR")
            crewSugestion.value = repository.getCrewSugestionRepo("2ae684da617a0a9eb2d4bd28815050e8", "pt-BR")
        }
    }


    private fun getAllGeneros() = arrayListOf(
        Genero(1, "Ação", R.drawable.placeholder_genero),
        Genero(2, "Sci-Fi", R.drawable.scifi),
        Genero(3, "Comédia", R.drawable.comedia),
        Genero(4, "Terror", R.drawable.terror)
    )

    private fun getAllJogadoresRank1() = arrayListOf(
        Jogador("Jogador 1", "10 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 2", "9 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 3", "8 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 4", "7 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 5", "6 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 6", "5 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 7", "4 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 8", "3 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 9", "2 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 10", "1 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
    )

    private fun getAllJogadoresRank2() = arrayListOf(
        Jogador("Jogador 1", "10 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 2", "9 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 3", "8 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 4", "7 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 5", "6 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 6", "5 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 7", "4 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 8", "3 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 9", "2 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
        Jogador("Jogador 10", "1 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
    )


}