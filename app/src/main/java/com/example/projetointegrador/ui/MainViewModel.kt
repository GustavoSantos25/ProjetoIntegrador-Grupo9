package com.example.projetointegrador.ui

import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.*
import com.example.projetointegrador.services.Repository
import com.example.projetointegrador.services.repository
import kotlinx.android.synthetic.main.toolbar_quiz.view.*
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(repository: Repository) : ViewModel() {
    val listGeneros = MutableLiveData<ArrayList<Genero>>()
    val pagesRanking = MutableLiveData<ArrayList<ArrayList<Jogador>>>()
    val listGenres = MutableLiveData<Genres>()
    val filmeSugestion = MutableLiveData<Filme>()
    val crewSugestion = MutableLiveData<Crew>()
    val lastMovieId = MutableLiveData<Int>()
    val listTemplates = popTemplates()
    val pergunta = MutableLiveData<Pergunta>()
    val timer = MutableLiveData<String>()
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
            crewSugestion.value = repository.getCrewSugestionRepo(apiKey, "pt-BR")
        }
    }

    fun generateRandomQuestion() {

        viewModelScope.launch {

            var idFilme = 0
            var alternativas = 0
            var sucesso = false
            val indiceEnunciado = (0 until 2).random()

            var perguntaGerada = Pergunta()

            perguntaGerada.enunciado = listTemplates[indiceEnunciado]
            lastMovieId.value = 700000

            while (!sucesso) {
                try {
                    if (indiceEnunciado == 0) {
                        val anos = ArrayList<String>()
                        while (alternativas < 4) {

                            idFilme = (0..lastMovieId.value!!).random()
                            val filme: Filme = repository.getMovieById(idFilme, apiKey)

                            if (filme.release_date.isNotEmpty()) {

                                val anoDeLancamento = filme.release_date.substring(0, 4)
                                //Verificar se o ano já está nas alternativas
                                if (anos.contains(anoDeLancamento)) {
                                    continue
                                }

                                alternativas++
                                anos.add(anoDeLancamento)

                                when (alternativas) {
                                    1 -> {
                                        perguntaGerada.enunciado = perguntaGerada.enunciado.replace("REPLACE", filme.title)
                                        perguntaGerada.alternativaCerta = anoDeLancamento
                                        perguntaGerada.genero = filme.genres[0].name
                                    }
                                    2 -> perguntaGerada.segundaAlternativa = anoDeLancamento
                                    3 -> perguntaGerada.terceiraAlternativa = anoDeLancamento
                                    4 -> perguntaGerada.quartaAlternativa = anoDeLancamento
                                }
                            }
                        }
                    } else if (indiceEnunciado == 1) {
                        val paises = ArrayList<String>()
                        while (alternativas < 4) {

                            idFilme = (0..lastMovieId.value!!).random()
                            val filme: Filme = repository.getMovieById(idFilme, apiKey)

                            if (filme.production_countries.size != 0) {

                                val paisDeProducao = filme.production_countries[0].name
                                //Verificar se o país já está nas alternativas
                                if (paises.contains(paisDeProducao)) {
                                    continue
                                }

                                alternativas++
                                paises.add(paisDeProducao)

                                when (alternativas) {
                                    1 -> {
                                        perguntaGerada.enunciado = perguntaGerada.enunciado.replace("REPLACE", filme.title)
                                        perguntaGerada.alternativaCerta = paisDeProducao
                                    }
                                    2 -> perguntaGerada.segundaAlternativa = paisDeProducao
                                    3 -> perguntaGerada.terceiraAlternativa = paisDeProducao
                                    4 -> perguntaGerada.quartaAlternativa = paisDeProducao
                                }
                            }
                        }
                    }
                    sucesso = true
                    pergunta.value = perguntaGerada
                } catch (ignored: Exception) {

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

    fun atualizarAcertos(textView: TextView, acertos: Int) {
        val texto = "$acertos \n Acertos"
        textView.text = texto
    }

    fun atualizarGeneroToolbar(toolbar: Toolbar) {
        toolbar.tvGeneroPergunta.text = pergunta.value?.genero
    }

    fun popAlternativas(listBotoes: Array<AppCompatButton>) {
        val indicesPopulados = arrayListOf<Int>()
        val alternativasUsadas = arrayListOf<Int>()

        while (indicesPopulados.size != 4) {

            var indice = (0 until 4).random()
            while (indicesPopulados.contains(indice)) {
                indice = (0 until 4).random()
            }

            indicesPopulados.add(indice)

            var alternativa = (0 until 4).random()
            while (alternativasUsadas.contains(alternativa)) {
                alternativa = (0 until 4).random()
            }

            alternativasUsadas.add(alternativa)

            when (alternativa) {
                0 -> {
                    listBotoes[indice].text = pergunta.value?.alternativaCerta
                }
                1 -> {
                    listBotoes[indice].text = pergunta.value?.segundaAlternativa
                }
                2 -> {
                    listBotoes[indice].text = pergunta.value?.terceiraAlternativa
                }
                3 -> {
                    listBotoes[indice].text = pergunta.value?.quartaAlternativa
                }
            }
        }
    }

    fun updateTimer(){
        timer.value = "00:31"
        var newTime : Long = 31000
        var clock = object : CountDownTimer(newTime, 1000){
            override fun onTick(p0: Long) {
                newTime = p0
                updateStringTimer(newTime)
            }

            override fun onFinish() {
                cancel()
            }

        }.start()
    }

    private fun updateStringTimer(timeRemaining : Long){
        val minutes = timeRemaining / 60000
        val seconds = timeRemaining % 60000 / 1000
        var newString = "$minutes"
        newString += ":"
        if(seconds < 10) newString += "0"
        newString += "$seconds"
        timer.value = newString
    }
}