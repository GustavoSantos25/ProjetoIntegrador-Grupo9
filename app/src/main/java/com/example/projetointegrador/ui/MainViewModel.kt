package com.example.projetointegrador.ui

import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegrador.R
import com.example.projetointegrador.domain.*
import com.example.projetointegrador.services.*
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainViewModel(repository: Repository, dbRepository: DBRepository) : ViewModel() {
    val listGeneros = MutableLiveData<ArrayList<Genero>>()
    val pagesRanking = MutableLiveData<ArrayList<ArrayList<Jogador>>>()
    val listGenres = MutableLiveData<Genres>()
    val filmeSugestion = MutableLiveData<Filme>()
    val crewSugestion = MutableLiveData<Crew>()
    var listSugestion = ArrayList<Filme>()
    val lastMovieId = MutableLiveData<Int>()
    val listTemplates = popTemplates()
    val pergunta = MutableLiveData<Pergunta>()
    var acertos = MutableLiveData(0)
    var jogadorLogado = MutableLiveData<MutableMap<String, Any>>()
    var countFilmeSugestionPerLogin = 1
    private val _navigateScreen = MutableLiveData<Event<Int>>()
    val navigateScreen: MutableLiveData<Event<Int>> = _navigateScreen

    //Instancias do firebase
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var dbFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var collectionReference: CollectionReference

    var urlCapa: String = ""
    var urlAvatar: String = ""

    //Variáveis para o timer do modo Time Limit
    var clock: CountDownTimer = object : CountDownTimer(0, 0) {
        override fun onTick(millisUntilFinished: Long) {
            TODO("Not yet implemented")
        }

        override fun onFinish() {
            TODO("Not yet implemented")
        }

    }
    val timer = MutableLiveData<String>()
    var timeLeftInMili: Long = 60000
    var timeRunning: Boolean = false

    //Variável para ver se a pergunta está sendo carregada
    var carregandoPergunta = MutableLiveData<Boolean>()
    //Variável para ver se o card de sugestão está sendo carregado
    var carregandoCard = MutableLiveData<Boolean>()

    private val apiKey = "2ae684da617a0a9eb2d4bd28815050e8"
    private val IDIOMA = "pt-BR"
    private val POPULARIDADE_MINIMA = 2.0

    //val dbRepository: DBRepository
    val configuracoes = MutableLiveData<Configuracoes>()
    val emailUser = MutableLiveData<String>()
    val facebookIsLogged = MutableLiveData<Boolean>()
    val googleIsLogged = MutableLiveData<Boolean>()
    val auth = MutableLiveData<FirebaseAuth>()
    val googleSignInClient = MutableLiveData<GoogleSignInClient>()
    val jaTemUsername = MutableLiveData<Boolean>()
    val usernameCriado = MutableLiveData<Boolean>()

    //Enum para ver qual modo de jogo foi escolhido
    lateinit var modoDeJogo: ModosDeJogo

    var recordeSobrevivencia = MutableLiveData<Int>()
    var recordeTimeLimit = MutableLiveData<Int>()

    val listJogadoresSobrevivencia = MutableLiveData<ArrayList<Jogador>>()
    val listJogadoresTimeLimit = MutableLiveData<ArrayList<Jogador>>()

    var jogadorClicado = Jogador()

    init {
        collectionReference = dbFirestore.collection("jogadores")
    }

    fun verificarSeTemUsername() {
        val uidUsuario: String = firebaseAuth.currentUser!!.uid
        val docRef = dbFirestore.collection("jogadores").document(uidUsuario)

        docRef.get()
            .addOnSuccessListener { document ->
                if (document == null) {
                    jaTemUsername.value = false
                } else if (document["userName"] != null) {
                    jaTemUsername.value = document["username"].toString().isNotEmpty()
                } else {
                    jaTemUsername.value = false
                }
            }
    }

    fun criarUsername(userName: String) {

        var usernameValido: Boolean

        dbFirestore.collection("jogadores")
            .whereEqualTo("userName", userName)
            .get()
            .addOnSuccessListener { documents ->

                usernameValido = documents.isEmpty

                if (usernameValido) {
                    val jogador = getDadosJogador(
                        firebaseAuth.currentUser!!.uid,
                        userName,
                        "",
                        0,
                        0,
                        ArrayList(),
                        "",
                        ""
                    )

                    sendJogador(jogador)

                    usernameCriado.value = true
                } else {
                    usernameCriado.value = false
                }
            }
            .addOnFailureListener {
                usernameCriado.value = false
                firebaseAuth.signOut()
            }
    }


    fun getDadosJogador(
        uid: String,
        userName: String,
        bio: String,
        recordeTimeLimit: Int,
        recordeSobrevivencia: Int,
        generosFavoritos: ArrayList<Int>,
        urlAvatar: String,
        urlCapa: String
    ): MutableMap<String, Any> {

        val jogador: MutableMap<String, Any> = HashMap()

        jogador["uid"] = uid
        jogador["userName"] = userName
        jogador["bio"] = bio
        jogador["recordeTimeLimit"] = recordeTimeLimit
        jogador["recordeSobrevivencia"] = recordeSobrevivencia
        jogador["generosFavoritos"] = generosFavoritos
        jogador["urlAvatar"] = urlAvatar
        jogador["urlCapa"] = urlCapa

        return jogador
    }

    fun getDadosJogadorLogado() {
        val docRef = dbFirestore.collection("jogadores")
            .document(firebaseAuth.uid!!)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    jogadorLogado.value = document.data
                    getCurrentRecorde()
                }
            }
    }

    fun sendJogador(jogador: MutableMap<String, Any>) {
        val uid = jogador["uid"].toString()
        collectionReference.document(uid).set(jogador)
    }

    fun deleteJogador(jogadorUser : String){

    }


    fun updateJogador(jogador: MutableMap<String, Any>) {
        val uid = jogador["uid"].toString()
        collectionReference.document(uid).update(jogador)
    }

    fun updateBio(bio: String) {
        dbFirestore.collection("jogadores")
            .document(firebaseAuth.uid!!)
            .update("bio", bio)
    }

    fun updateCapa(urlCapa: String) {
        dbFirestore.collection("jogadores")
            .document(firebaseAuth.uid!!)
            .update("urlCapa", urlCapa)
    }

    fun updateAvatar(urlAvatar: String) {
        dbFirestore.collection("jogadores")
            .document(firebaseAuth.uid!!)
            .update("urlAvatar", urlAvatar)
    }

    fun updateRecorde(field: String) {
        dbFirestore.collection("jogadores")
            .document(firebaseAuth.uid!!)
            .update(field, acertos.value?.toInt())
    }

    fun deleteCapaAntiga() {
        val urlCapa: String = jogadorLogado.value?.get("urlCapa").toString()
        if (urlCapa.isNotEmpty()) {
            FirebaseStorage.getInstance().getReferenceFromUrl(urlCapa).delete()
        }
    }

    fun deleteAvatarAntigo() {
        val urlAvatar: String = jogadorLogado.value?.get("urlAvatar").toString()
        if (urlAvatar.isNotEmpty()) {
            FirebaseStorage.getInstance().getReferenceFromUrl(urlAvatar).delete()
        }
    }

    fun popListGeneros() {
        viewModelScope.launch {
            listGeneros.value = getAllGeneros()
        }
    }

    fun getCurrentRecorde() {
        recordeSobrevivencia.value =
            Integer.parseInt(jogadorLogado.value?.get("recordeSobrevivencia").toString())
        recordeTimeLimit.value =
            Integer.parseInt(jogadorLogado.value?.get("recordeTimeLimit").toString())
    }

    fun verificarNovoRecorde() {
        if (novoRecorde()) {
            val field =
                if (modoDeJogo == ModosDeJogo.SOBREVIVENCIA) "recordeSobrevivencia" else "recordeTimeLimit"
            updateRecorde(field)
        }
    }

    fun novoRecorde(): Boolean {
        return if (modoDeJogo == ModosDeJogo.SOBREVIVENCIA) {
            acertos.value!! > recordeSobrevivencia.value!!
        } else {
            acertos.value!! > recordeTimeLimit.value!!
        }
    }

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
            if(countFilmeSugestionPerLogin > 0){
                carregandoCard.value = true
                val generosFavoritos = jogadorLogado.value!!["generosFavoritos"] as ArrayList<Int>
                //val generoEscolhido  : Int = generosFavoritos.random()
                listSugestion =
                    repository.getSugestionMovieRepo(apiKey, IDIOMA, "popularity.desc", 80).results
                filmeSugestion.value = listSugestion.random()
                crewSugestion.value =
                    repository.getCrewMovieSugestionRepo(filmeSugestion.value!!.id, apiKey, IDIOMA)
                countFilmeSugestionPerLogin--
                carregandoCard.value = false
            }
        }

    }

    fun gerarPerguntaAleatoria() {

        carregandoPergunta.value = true

        viewModelScope.launch {

            val indiceEnunciado = (0 until 3).random()
//            val indiceEnunciado = 1
            val perguntaGerada = Pergunta()

            perguntaGerada.enunciado = listTemplates[indiceEnunciado]

            when (indiceEnunciado) {
                0 -> primeiroTemplate(perguntaGerada)
                1 -> segundoTemplate(perguntaGerada)
                2 -> terceiroTemplate(perguntaGerada)
                3 -> quartoTemplate(perguntaGerada)
            }

            carregandoPergunta.value = false
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


                    if(filme.production_countries.find { it.name == "China" } != null || filme.production_countries.find { it.name == "Japan" } != null) continue
                    if (filme.popularity < POPULARIDADE_MINIMA && alternativas == 0) continue


                    if (filme.release_date.isNotEmpty() && filme.popularity >= POPULARIDADE_MINIMA) {

                        val anoDeLancamento: Int =
                            Integer.parseInt(filme.release_date.trim().substring(0, 4))
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


                    if(filme.production_countries.find { it.name == "China" } != null || filme.production_countries.find { it.name == "Japan" } != null) continue
                    if (filme.popularity < POPULARIDADE_MINIMA && alternativas == 0) continue


                    var paisDeProducao =
                        filme.production_countries[0].name.toUpperCase(Locale.ROOT).trim()

                    paisDeProducao = dbRepository.getPaisPortuguesDBService(paisDeProducao)

                    if (filme.production_countries.size != 0) {

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

                    if(filme.production_countries.find { it.name == "China" } != null || filme.production_countries.find { it.name == "Japan" } != null) continue
                    if (filme.popularity < POPULARIDADE_MINIMA && alternativas == 0) continue


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

                    if(filme.production_countries.find { it.name == "China" } != null || filme.production_countries.find { it.name == "Japan" } != null) continue
                    if ((filme.popularity < POPULARIDADE_MINIMA && alternativas == 0) || filme.popularity < POPULARIDADE_MINIMA) continue


                    val nomeFilme = filme.title.trim().toUpperCase(Locale.ROOT)
                    val sinopse = filme.overview.trim()

                    if ((sinopse.isNotEmpty() && sinopse.count() < 450 && alternativas == 0) || alternativas > 0) {

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

    fun popPagesRanking() {
        viewModelScope.launch {
            pagesRanking.value =
                arrayListOf(listJogadoresSobrevivencia.value!!, listJogadoresTimeLimit.value!!)
        }
    }

    fun getDadosJogadoresSobrevivencia() {

        val listJogadores = ArrayList<Jogador>()

        dbFirestore.collection("jogadores")
            .whereGreaterThanOrEqualTo("recordeSobrevivencia", 1)
            .orderBy("recordeSobrevivencia", Query.Direction.DESCENDING)
            .limit(15)
            .get()
            .addOnSuccessListener { document ->
                document?.forEach { jogador ->
                    listJogadores.add(
                        Jogador(
                            jogador["uid"].toString(),
                            jogador["userName"].toString(),
                            jogador["bio"].toString(),
                            jogador["recordeTimeLimit"].toString().toInt(),
                            jogador["recordeSobrevivencia"].toString().toInt(),
                            jogador["generosFavoritos"] as ArrayList<Int>,
                            jogador["urlAvatar"].toString(),
                            jogador["urlCapa"].toString(),
                        )
                    )
                }

                listJogadoresSobrevivencia.value = listJogadores
            }
    }

    fun getDadosJogadoresTimeLimit() {

        val listJogadores = ArrayList<Jogador>()

        dbFirestore.collection("jogadores")
            .whereGreaterThanOrEqualTo("recordeTimeLimit", 1)
            .orderBy("recordeTimeLimit", Query.Direction.DESCENDING)
            .limit(15)
            .get()
            .addOnSuccessListener { document ->
                document?.forEach { jogador ->
                    listJogadores.add(
                        Jogador(
                            jogador["uid"].toString(),
                            jogador["userName"].toString(),
                            jogador["bio"].toString(),
                            jogador["recordeTimeLimit"].toString().toInt(),
                            jogador["recordeSobrevivencia"].toString().toInt(),
                            jogador["generosFavoritos"] as ArrayList<Int>,
                            jogador["urlAvatar"].toString(),
                            jogador["urlCapa"].toString(),
                        )
                    )
                }

                listJogadoresTimeLimit.value = listJogadores
            }
    }

    private fun popTemplates() = arrayListOf(
        "Em que ano o filme \"REPLACE\" foi lançado?",
        "Qual o país de produção do filme \"REPLACE\"?",
        "Qual o diretor do filme \"REPLACE\"?",
        "A qual filme se refere a sinopse \"REPLACE\"?"
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
        }
    }

    fun createConfigurationForUser(email: String) {
        viewModelScope.launch {
            val config = Configuracoes(email = email, vibrar = true, notificacoes = true)
            dbRepository.addConfiguracoesTask(config)
            configuracoes.value = config
        }
    }

    fun updateConfiguracoes(isChecked: Boolean, campo: String) {
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

//    fun updateGoogleLogIn(isLogged: Boolean) {
//        googleIsLogged.value = isLogged
//    }
//
//    fun configFacebook(fauth: FirebaseAuth) {
//        auth.value = fauth
//    }
//
//    fun configGoogle(gclient: GoogleSignInClient) {
//        googleSignInClient.value = gclient
//    }

    fun onAcerto(): Int {
        acertos.value = acertos.value?.plus(1)
        return acertos.value!!
    }

    fun acertoSingularOuPlural(): String {
        return when (acertos.value) {
            1 -> "Acerto"
            else -> "Acertos"
        }
    }

    fun startTimer() {
        timer.value = "01:00"
        var newTime: Long = timeLeftInMili
        clock = object : CountDownTimer(newTime, 1000) {
            override fun onTick(p0: Long) {
                timeLeftInMili = p0
                updateTimer()
            }

            override fun onFinish() {
                cancel()
                timeLeftInMili = 60000
                timeRunning = false
            }

        }.start()
        timeRunning = true
    }

    fun stopTimer() {
        clock.cancel()
        timeRunning = false
    }

    fun cancelTimer(){
        clock.onFinish()
    }


    fun startStopTimer() {
        if (timeRunning) stopTimer()
        else startTimer()
    }

    fun updateTimer() {
        val minutes = timeLeftInMili / 60000
        val seconds = timeLeftInMili % 60000 / 1000
        var newString = "$minutes"
        newString += ":"
        if (seconds < 10) newString += "0"
        newString += "$seconds"
        timer.value = newString
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

    fun goToHome() {
        _navigateScreen.value = Event(R.id.homeVPFragment)
    }

    fun goToPerfilTerceiro() {
        _navigateScreen.value = Event(R.id.perfilTerceiroFragment)
    }

    fun goToSinopse() {
        _navigateScreen.value = Event(R.id.sinopseFragment)
    }

    fun goToRanking() {
        _navigateScreen.value = Event(R.id.rankingFragment)
    }

    fun goToPergunta() {
        _navigateScreen.value = Event(R.id.perguntaFragment)
    }

    fun goToSobrevivencia() {
        _navigateScreen.value = Event(R.id.sobrevivenciaFragment)
    }

    fun goToResultado() {
        _navigateScreen.value = Event(R.id.resultadoFragment)
    }

    fun goToAjuda() {
        _navigateScreen.value = Event(R.id.ajudaFragment)
    }

}

