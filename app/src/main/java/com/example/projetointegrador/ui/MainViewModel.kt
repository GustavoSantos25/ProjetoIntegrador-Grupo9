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
    val lastMovieId = MutableLiveData<Int>()
    val listTemplates = popTemplates()
    val pergunta = MutableLiveData<Pergunta>()
    private val apiKey = "2ae684da617a0a9eb2d4bd28815050e8"

    fun popListGeneros() {
        viewModelScope.launch {
            listGeneros.value = getAllGeneros()
        }
    }

    fun popPagesRanking() {
        viewModelScope.launch {
            pagesRanking.value = arrayListOf(getAllJogadoresRank1(), getAllJogadoresRank2())
        }
    }

    fun updateLastMovieId() {
        viewModelScope.launch {
            lastMovieId.value = repository.getLastMovieInApi(apiKey).id
        }
    }

    fun popListGenres() {
        viewModelScope.launch {
            listGenres.value = repository.getGenerosRepo(apiKey)
        }
    }

    fun getFilmeSugestion() {
        viewModelScope.launch {
            filmeSugestion.value = repository.getFilmeSugestionRepo(apiKey, "pt-BR")
        }
    }

    fun generateRandomQuestion() {

        viewModelScope.launch {

            val indiceEnunciado = (0 until 2).random()
            pergunta.value?.enunciado = listTemplates[indiceEnunciado]

            lastMovieId.value = 700000

            var idFilme = (0..lastMovieId.value!!).random()

            var alternativas = 0
            var filme: Filme = repository.getMovieById(idFilme, apiKey)

            if (indiceEnunciado == 0) {

                while (alternativas < 4) {
                    if (filme.release_date.isNotEmpty()) {

                        alternativas++

                        val anoDeLancamento = filme.release_date.substring(0, 4)

                        when (alternativas) {
                            1 -> {
                                pergunta.value?.enunciado?.replace("REPLACE", filme.title)
                                pergunta.value?.alternativaCerta = anoDeLancamento
                            }
                            2 -> pergunta.value?.segundaAlternativa = anoDeLancamento
                            3 -> pergunta.value?.terceiraAlternativa = anoDeLancamento
                            4 -> pergunta.value?.quartaAlternativa = anoDeLancamento
                        }

                        idFilme = (0 until lastMovieId.value!!).random()
                        filme = repository.getMovieById(idFilme, apiKey)
                    }
                }
            } else if (indiceEnunciado == 1) {
                while (alternativas < 4) {
                    if (filme.production_countries.size != 0) {

                        alternativas++

                        val paisDeProducao = filme.production_countries[0].name

                        when (alternativas) {
                            1 -> {
                                pergunta.value?.enunciado?.replace("REPLACE", filme.title)
                                pergunta.value?.alternativaCerta = paisDeProducao
                            }
                            2 -> pergunta.value?.segundaAlternativa = paisDeProducao
                            3 -> pergunta.value?.terceiraAlternativa = paisDeProducao
                            4 -> pergunta.value?.quartaAlternativa = paisDeProducao
                        }

                        idFilme = (0 until lastMovieId.value!!).random()
                        filme = repository.getMovieById(idFilme, apiKey)
                    }
                }
            }
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

    private fun popTemplates() = arrayListOf(
        "Em que ano o filme REPLACE foi lançado?",
        "Qual o país de produção do filme REPLACE?"
    )
}