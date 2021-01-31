package com.example.projetointegrador.ui

import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.*
import com.example.projetointegrador.services.DBRepository
import com.example.projetointegrador.services.Repository
import com.example.projetointegrador.services.dbRepository
import com.example.projetointegrador.services.repository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(repositorys: Repository, dbRepository: DBRepository) : ViewModel() {
    val listGeneros = MutableLiveData<ArrayList<Genero>>()
    val pagesRanking = MutableLiveData<ArrayList<ArrayList<Jogador>>>()
    val listGenres = MutableLiveData<Genres>()
    val filmeSugestion = MutableLiveData<Filme>()
    val crewSugestion = MutableLiveData<Crew>()
    val lastMovieId = MutableLiveData<Int>()
    val listTemplates = popTemplates()
    val pergunta = MutableLiveData<Pergunta>()
    var acertos = 0
    private val apiKey = "2ae684da617a0a9eb2d4bd28815050e8"
    private val IDIOMA = "pt-BR"

    //val dbRepository: DBRepository
    val configuracoes = MutableLiveData<Configuracoes>()
    val emailUser = MutableLiveData<String>()
    val facebookIsLogged = MutableLiveData<Boolean>()
    val googleIsLogged = MutableLiveData<Boolean>()
    val auth = MutableLiveData<FirebaseAuth>()
    val googleSignInClient = MutableLiveData<GoogleSignInClient>()

    //Variável para ver qual modo de jogo foi escolhido
    var modoSobrevivencia = false

    fun popListGeneros() {
        viewModelScope.launch {
            listGeneros.value = getAllGeneros()
        }
    }

//    fun popPagesRanking() {
//        viewModelScope.launch {
//            pagesRanking.value = arrayListOf(getAllJogadoresRank1(), getAllJogadoresRank2())
//        }
//    }

    fun updateLastMovieId() {
        viewModelScope.launch {
            lastMovieId.value = repository.getLastMovieInApi(apiKey, "pt-BR").id
        }
    }

    fun popListGenres() {
        viewModelScope.launch {
            listGenres.value = repository.getGenerosRepo(apiKey)
        }
    }

    fun getFilmeSugestion() {
        viewModelScope.launch {
            filmeSugestion.value = repository.getFilmeSugestionRepo(apiKey, IDIOMA)
            crewSugestion.value = repository.getCrewSugestionRepo(apiKey, IDIOMA)
        }
    }

    fun gerarPerguntaAleatoria() {

        viewModelScope.launch {

            val indiceEnunciado = (0 until 4).random()
            val perguntaGerada = Pergunta()

            perguntaGerada.enunciado = listTemplates[indiceEnunciado]

            when (indiceEnunciado) {
                0 -> primeiroTemplate(perguntaGerada)
                1 -> segundoTemplate(perguntaGerada)
                2 -> terceiroTemplate(perguntaGerada)
                3 -> quartoTemplate(perguntaGerada)
            }

            pergunta.value = perguntaGerada
        }
    }

    //Template de ano de lançamento
    private suspend fun primeiroTemplate(perguntaGerada: Pergunta) {

        var idFilme: Int
        var alternativas = 0
        var sucesso = false
        val anos = ArrayList<Int>()
        val anoAtual: Int = Calendar.getInstance().get(Calendar.YEAR)

        while (!sucesso) {
            try {
                while (alternativas < 4) {

                    idFilme = (0..lastMovieId.value!!).random()
                    val filme: Filme = repository.getMovieById(idFilme, apiKey, IDIOMA)

                    if (filme.popularity < 4.0 && alternativas == 0) continue

                    if (filme.release_date.isNotEmpty() && filme.popularity >= 4.0) {

                        val anoDeLancamento: Int = Integer.parseInt(filme.release_date.trim().substring(0, 4))
                        //Verificar se o ano já está nas alternativas
                        if (anos.contains(anoDeLancamento) || anoDeLancamento > anoAtual) {
                            continue
                        }

                        alternativas++
                        anos.add(anoDeLancamento)

                        when (alternativas) {
                            1 -> {
                                perguntaGerada.enunciado =
                                    perguntaGerada.enunciado.replace("REPLACE", filme.title)
                                perguntaGerada.alternativaCerta = anoDeLancamento.toString()
                                perguntaGerada.genero = filme.genres[0].name
                            }
                            2 -> perguntaGerada.segundaAlternativa = anoDeLancamento.toString()
                            3 -> perguntaGerada.terceiraAlternativa = anoDeLancamento.toString()
                            4 -> perguntaGerada.quartaAlternativa = anoDeLancamento.toString()
                        }
                    }
                }
                sucesso = true
            } catch (ignored: Exception) {

            }
        }
    }

    //Template de país de produção
    private suspend fun segundoTemplate(perguntaGerada: Pergunta) {

        var idFilme: Int
        var alternativas = 0
        var sucesso = false
        val paises = ArrayList<String>()

        while (!sucesso) {
            try {
                while (alternativas < 4) {

                    idFilme = (0..lastMovieId.value!!).random()
                    val filme: Filme = repository.getMovieById(idFilme, apiKey, IDIOMA)

                    if (filme.popularity < 4.0 && alternativas == 0) continue

                    if (filme.production_countries.size != 0) {

                        val paisDeProducao =
                            filme.production_countries[0].name.toUpperCase(Locale.ROOT).trim()
                        //Verificar se o país já está nas alternativas
                        if (paises.contains(paisDeProducao) || paisDeProducao.isEmpty()) {
                            continue
                        }

                        alternativas++
                        paises.add(paisDeProducao)

                        when (alternativas) {
                            1 -> {
                                perguntaGerada.enunciado =
                                    perguntaGerada.enunciado.replace("REPLACE", filme.title)
                                perguntaGerada.alternativaCerta = paisDeProducao
                            }
                            2 -> perguntaGerada.segundaAlternativa = paisDeProducao
                            3 -> perguntaGerada.terceiraAlternativa = paisDeProducao
                            4 -> perguntaGerada.quartaAlternativa = paisDeProducao
                        }
                    }
                }
                sucesso = true
            } catch (ignored: Exception) {

            }
        }
    }

    //Template de diretor
    private suspend fun terceiroTemplate(perguntaGerada: Pergunta) {

        var idFilme: Int
        var alternativas = 0
        var sucesso = false
        val diretores = ArrayList<String>()

        while (!sucesso) {
            try {
                while (alternativas < 4) {

                    idFilme = (0..lastMovieId.value!!).random()
                    val filme: Filme = repository.getMovieById(idFilme, apiKey, IDIOMA)

                    if (filme.popularity < 4.0 && alternativas == 0) continue

                    val credits = repository.getMovieCredits(idFilme, apiKey, IDIOMA)
                    var diretor = ""

                    //Pega o diretor do filme
                    credits.crew.forEach {
                        if (it.job == "Director") diretor = it.name.trim().toUpperCase(Locale.ROOT)
                    }

                    if (diretor.isNotEmpty()) {

                        //Verificar se o diretor já está nas alternativas
                        if (diretores.contains(diretor)) {
                            continue
                        }

                        alternativas++
                        diretores.add(diretor)

                        when (alternativas) {
                            1 -> {
                                perguntaGerada.enunciado =
                                    perguntaGerada.enunciado.replace("REPLACE", filme.title)
                                perguntaGerada.alternativaCerta = diretor
                            }
                            2 -> perguntaGerada.segundaAlternativa = diretor
                            3 -> perguntaGerada.terceiraAlternativa = diretor
                            4 -> perguntaGerada.quartaAlternativa = diretor
                        }
                    }
                }
                sucesso = true
            } catch (ignored: Exception) {

            }
        }
    }

    //Template de sinopse
    private suspend fun quartoTemplate(perguntaGerada: Pergunta) {

        var idFilme: Int
        var alternativas = 0
        var sucesso = false
        val filmes = ArrayList<String>()

        while (!sucesso) {
            try {
                while (alternativas < 4) {

                    idFilme = (0..lastMovieId.value!!).random()
                    val filme: Filme = repository.getMovieById(idFilme, apiKey, IDIOMA)

                    if ((filme.popularity < 4.0 && alternativas == 0) || filme.popularity < 3.0) continue

                    val nomeFilme = filme.title.trim().toUpperCase(Locale.ROOT)
                    val sinopse = filme.overview.trim()

                    if ((sinopse.isNotEmpty() && alternativas == 0) || alternativas > 0) {

                        //Verificar se o diretor já está nas alternativas
                        if (filmes.contains(nomeFilme)) {
                            continue
                        }

                        alternativas++
                        filmes.add(nomeFilme)

                        when (alternativas) {
                            1 -> {
                                perguntaGerada.enunciado =
                                    perguntaGerada.enunciado.replace("REPLACE", sinopse)
                                perguntaGerada.alternativaCerta = nomeFilme
                            }
                            2 -> perguntaGerada.segundaAlternativa = nomeFilme
                            3 -> perguntaGerada.terceiraAlternativa = nomeFilme
                            4 -> perguntaGerada.quartaAlternativa = nomeFilme
                        }
                    }
                }
                sucesso = true
            } catch (ignored: Exception) {

            }
        }
    }

    private fun getAllGeneros() = arrayListOf(
        Genero(1, "Ação", R.drawable.placeholder_genero),
        Genero(2, "Sci-Fi", R.drawable.scifi),
        Genero(3, "Comédia", R.drawable.comedia),
        Genero(4, "Terror", R.drawable.terror)
    )

//    private fun getAllJogadoresRank1() = arrayListOf(
//        Jogador("Jogador 1", "10 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 2", "9 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 3", "8 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 4", "7 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 5", "6 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 6", "5 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 7", "4 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 8", "3 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 9", "2 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 10", "1 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//    )

//    private fun getAllJogadoresRank2() = arrayListOf(
//        Jogador("Jogador 1", "10 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 2", "9 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 3", "8 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 4", "7 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 5", "6 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 6", "5 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 7", "4 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 8", "3 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 9", "2 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//        Jogador("Jogador 10", "1 ACERTOS", R.drawable.ic_undraw_male_avatar_323b),
//    )

    private fun popTemplates() = arrayListOf(
        "Em que ano o filme \"REPLACE\" foi lançado?",
        "Qual o país de produção do filme \"REPLACE\"?",
        "Qual o diretor do filme \"REPLACE\"?",
        "A a qual filme se refere a sinopse \"REPLACE\"?"
    )

    fun atualizarAcertos(textView: TextView, acertos: Int) {
        val texto = "$acertos \n Acertos"
        textView.text = texto
    }

//    fun atualizarGeneroToolbar(toolbar: Toolbar) {
//        toolbar.tvGeneroPergunta.text = pergunta.value?.genero
//    }

    //Método para popular as alternativas
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
                0 -> listBotoes[indice].text = pergunta.value?.alternativaCerta
                1 -> listBotoes[indice].text = pergunta.value?.segundaAlternativa
                2 -> listBotoes[indice].text = pergunta.value?.terceiraAlternativa
                3 -> listBotoes[indice].text = pergunta.value?.quartaAlternativa
            }
        }
    }

    fun initializeOfflineTemplates() {
        viewModelScope.launch {
            if (dbRepository.getAllTemplatesTask() == null) {
                dbRepository.addTemplateTask(
                    Template(
                        1, "Em que ano o filme",
                        "foi lançado?", "filme_name"
                    )
                )
                dbRepository.addTemplateTask(
                    Template(
                        1, "Qual o país de produção do filme",
                        "", "country"
                    )
                )
                dbRepository.addTemplateTask(
                    Template(
                        1, "Qual o diretor do filme REPLACE?",
                        "", "director"
                    )
                )
                dbRepository.addTemplateTask(
                    Template(
                        1, "A a qual filme se refere a sinopse",
                        "", "filme_name"
                    )
                )
            }
        }
    }

    fun carregarConfiguracoes(email: String) {
        viewModelScope.launch {

        }
    }

    fun getConfigurationForUser(email: String) {
        viewModelScope.launch {
            val config = dbRepository.getConfiguracoesForUserTask(email)
            configuracoes.value = config
            if (config == null) Log.i("NULL", "deu ruim")
        }
    }

    fun createConfigurationForUser(email: String) {
        viewModelScope.launch {
            val config = Configuracoes(email = email, vibrar = true, notificacoes = true)
            dbRepository.addConfiguracoesTask(config)
            configuracoes.value = config
        }
    }

    fun updateConfigurações(isChecked: Boolean, campo: String) {
        viewModelScope.launch {
            when (campo) {
                "vibrar" -> configuracoes.value!!.vibrar = isChecked
                "notificação" -> configuracoes.value!!.notificacoes = isChecked
            }
            dbRepository.updateConfiguracoesTask(configuracoes.value!!)
        }
    }

    fun atualizarEmailUser(email: String) {
        emailUser.value = email
    }

    fun updateFacebookLogIn(isLogged: Boolean) {
        facebookIsLogged.value = isLogged
    }

    fun updateGoogleLogIn(isLogged: Boolean) {
        googleIsLogged.value = isLogged
    }

    fun configFacebook(fauth: FirebaseAuth) {
        auth.value = fauth
    }

    fun configGoogle(gclient: GoogleSignInClient) {
        googleSignInClient.value = gclient
    }

    fun onAcerto(): String {
        acertos++

        return when (acertos) {
            1 -> "${acertos}\nacerto"
            else -> "${acertos}\nacertos"
        }
    }

    /*
    fun alterConfiguracoesDB(configuracoes: Configuracoes) {
        viewModelScope.launch {
            listaConfiguracoes.value = listOf(dbRepository.updateConfiguracoesTask(configuracoes))
        }
    }
    *
     */

    /*
    suspend fun initializeOfflineTemplates() {
        if (dbRepository.getAllTemplatesTask() == null) {
            dbRepository.addTemplateTask(Template(1, "Em que ano o filme",
                "foi lançado?", "filme_name"))
            dbRepository.addTemplateTask(Template(1, "Qual o país de produção do filme",
                "", "country"))
            dbRepository.addTemplateTask(Template(1, "Qual o diretor do filme REPLACE?",
                "", "director"))
            dbRepository.addTemplateTask(Template(1, "A a qual filme se refere a sinopse",
                "", "filme_name"))
        }
    }
    */
}