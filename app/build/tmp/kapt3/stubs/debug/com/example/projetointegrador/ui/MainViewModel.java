package com.example.projetointegrador.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0007\u0010\u0080\u0001\u001a\u00020\bJ\u001a\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010\u000b\u001a\u00020\rJ\u0011\u0010\u0085\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0086\u0001\u001a\u00020\bJ\u0011\u0010\u0087\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0086\u0001\u001a\u00020\bJ\u0011\u0010\u0088\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0086\u0001\u001a\u00020\bJ\u0011\u0010\u0089\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u008a\u0001\u001a\u00020\bJ\b\u0010\u008b\u0001\u001a\u00030\u0082\u0001J\u000f\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020N0MH\u0002J\u0011\u0010\u008d\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0086\u0001\u001a\u00020\bJ\b\u0010\u008e\u0001\u001a\u00030\u0082\u0001Jh\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020G0F2\u0007\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0006\u0010h\u001a\u00020\r2\u0006\u0010e\u001a\u00020\r2\u0018\u0010\u0092\u0001\u001a\u0013\u0012\u0004\u0012\u00020\r0Mj\t\u0012\u0004\u0012\u00020\r`\u0093\u00012\u0006\u0010v\u001a\u00020\b2\u0006\u0010{\u001a\u00020\bJ\b\u0010\u0094\u0001\u001a\u00030\u0082\u0001J\u0007\u00108\u001a\u00030\u0082\u0001J\b\u0010\u0095\u0001\u001a\u00030\u0082\u0001J\u0010\u0010\u0096\u0001\u001a\u00020\u00172\u0007\u0010\u0097\u0001\u001a\u00020\bJ\u0007\u0010\u0098\u0001\u001a\u00020\rJ\u001f\u0010\u0099\u0001\u001a\u00030\u0082\u00012\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u009b\u0001\u00a2\u0006\u0003\u0010\u009d\u0001J\b\u0010\u009e\u0001\u001a\u00030\u0082\u0001J\b\u0010\u009f\u0001\u001a\u00030\u0082\u0001J\u000f\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020\b0MH\u0002J\u001d\u0010\u00a1\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u00a2\u0001\u001a\u00020cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00a3\u0001J\u001d\u0010\u00a4\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u00a2\u0001\u001a\u00020cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00a3\u0001J\u001d\u0010\u00a5\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u00a2\u0001\u001a\u00020cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00a3\u0001J\u001d\u0010\u00a6\u0001\u001a\u00030\u0082\u00012\u0013\u0010\u00a7\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020G0FJ\b\u0010\u00a8\u0001\u001a\u00030\u0082\u0001J\b\u0010\u00a9\u0001\u001a\u00030\u0082\u0001J\b\u0010\u00aa\u0001\u001a\u00030\u0082\u0001J\u001d\u0010\u00ab\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u00a2\u0001\u001a\u00020cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00a3\u0001J\u0010\u0010\u00ac\u0001\u001a\u00030\u0082\u00012\u0006\u0010v\u001a\u00020\bJ\u0010\u0010\u00ad\u0001\u001a\u00030\u0082\u00012\u0006\u0010{\u001a\u00020\bJ\u001a\u0010\u00ae\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u00af\u0001\u001a\u00020\u00172\u0007\u0010\u00b0\u0001\u001a\u00020\bJ\u0011\u0010\u00b1\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u00b2\u0001\u001a\u00020\u0017J\u001d\u0010\u00b3\u0001\u001a\u00030\u0082\u00012\u0013\u0010\u00a7\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020G0FJ\b\u0010\u00b4\u0001\u001a\u00030\u0082\u0001J\b\u0010\u00b5\u0001\u001a\u00030\u0082\u0001J\b\u0010\u00b6\u0001\u001a\u00030\u0082\u0001R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000fR\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\f\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000fR\u0017\u00106\u001a\b\u0012\u0004\u0012\u0002070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000fR\u001a\u00109\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170\f\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000fR\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u000fR\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00170\f\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000fR,\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020G0F0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010\u000fR\u001d\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\u000fR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000fR \u0010S\u001a\b\u0012\u0004\u0012\u0002070MX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\b0M\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010UR\u001a\u0010Z\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R#\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0M0M0\f\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010\u000fR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010\u000fR \u0010e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000f\"\u0004\bg\u0010\u0011R \u0010h\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011R\u001a\u0010k\u001a\u00020lX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010\\\"\u0004\bs\u0010^R\u0017\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010\u000fR\u001a\u0010v\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010{\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010x\"\u0004\b}\u0010zR\u0017\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00170\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00b7\u0001"}, d2 = {"Lcom/example/projetointegrador/ui/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repositorys", "Lcom/example/projetointegrador/services/Repository;", "dbRepository", "Lcom/example/projetointegrador/services/DBRepository;", "(Lcom/example/projetointegrador/services/Repository;Lcom/example/projetointegrador/services/DBRepository;)V", "IDIOMA", "", "POPULARIDADE_MINIMA", "", "acertos", "Landroidx/lifecycle/MutableLiveData;", "", "getAcertos", "()Landroidx/lifecycle/MutableLiveData;", "setAcertos", "(Landroidx/lifecycle/MutableLiveData;)V", "apiKey", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "carregandoPergunta", "", "getCarregandoPergunta", "setCarregandoPergunta", "clock", "Landroid/os/CountDownTimer;", "getClock", "()Landroid/os/CountDownTimer;", "setClock", "(Landroid/os/CountDownTimer;)V", "collectionReference", "Lcom/google/firebase/firestore/CollectionReference;", "getCollectionReference", "()Lcom/google/firebase/firestore/CollectionReference;", "setCollectionReference", "(Lcom/google/firebase/firestore/CollectionReference;)V", "configuracoes", "Lcom/example/projetointegrador/domain/Configuracoes;", "getConfiguracoes", "crewSugestion", "Lcom/example/projetointegrador/domain/Crew;", "getCrewSugestion", "dbFirestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDbFirestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setDbFirestore", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "emailUser", "getEmailUser", "facebookIsLogged", "getFacebookIsLogged", "filmeSugestion", "Lcom/example/projetointegrador/domain/Filme;", "getFilmeSugestion", "firebaseAuth", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFirebaseAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "googleIsLogged", "getGoogleIsLogged", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "jaTemUsername", "getJaTemUsername", "jogadorLogado", "", "", "getJogadorLogado", "setJogadorLogado", "lastMovieId", "getLastMovieId", "listGeneros", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Genero;", "getListGeneros", "listGenres", "Lcom/example/projetointegrador/domain/Genres;", "getListGenres", "listSugestion", "getListSugestion", "()Ljava/util/ArrayList;", "setListSugestion", "(Ljava/util/ArrayList;)V", "listTemplates", "getListTemplates", "modoSobrevivencia", "getModoSobrevivencia", "()Z", "setModoSobrevivencia", "(Z)V", "pagesRanking", "Lcom/example/projetointegrador/domain/Jogador;", "getPagesRanking", "pergunta", "Lcom/example/projetointegrador/domain/Pergunta;", "getPergunta", "recordeSobrevivencia", "getRecordeSobrevivencia", "setRecordeSobrevivencia", "recordeTimeLimit", "getRecordeTimeLimit", "setRecordeTimeLimit", "timeLeftInMili", "", "getTimeLeftInMili", "()J", "setTimeLeftInMili", "(J)V", "timeRunning", "getTimeRunning", "setTimeRunning", "timer", "getTimer", "urlAvatar", "getUrlAvatar", "()Ljava/lang/String;", "setUrlAvatar", "(Ljava/lang/String;)V", "urlCapa", "getUrlCapa", "setUrlCapa", "usernameCriado", "getUsernameCriado", "acertoSingularOuPlural", "atualizarAcertos", "", "textView", "Landroid/widget/TextView;", "atualizarEmailUser", "email", "carregarConfiguracoes", "createConfigurationForUser", "criarUsername", "userName", "gerarPerguntaAleatoria", "getAllGeneros", "getConfigurationForUser", "getCurrentRecorde", "getDadosJogador", "uid", "bio", "generosFavoritos", "Lkotlin/collections/ArrayList;", "getDadosJogadorLogado", "initializeOfflineTemplates", "novoRecorde", "sobrevivenciaOuTimeLimit", "onAcerto", "popAlternativas", "listBotoes", "", "Landroidx/appcompat/widget/AppCompatButton;", "([Landroidx/appcompat/widget/AppCompatButton;)V", "popListGeneros", "popListGenres", "popTemplates", "primeiroTemplate", "perguntaGerada", "(Lcom/example/projetointegrador/domain/Pergunta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quartoTemplate", "segundoTemplate", "sendJogador", "jogador", "startStopTimer", "startTimer", "stopTimer", "terceiroTemplate", "updateAvatar", "updateCapa", "updateConfiguracoes", "isChecked", "campo", "updateFacebookLogIn", "isLogged", "updateJogador", "updateLastMovieId", "updateTimer", "verificarSeTemUsername", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.projetointegrador.domain.Genero>> listGeneros = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.util.ArrayList<com.example.projetointegrador.domain.Jogador>>> pagesRanking = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Genres> listGenres = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Filme> filmeSugestion = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Crew> crewSugestion = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.projetointegrador.domain.Filme> listSugestion;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> lastMovieId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> listTemplates = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Pergunta> pergunta = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> acertos;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Object>> jogadorLogado;
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.auth.FirebaseAuth firebaseAuth;
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.firestore.FirebaseFirestore dbFirestore;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.firestore.CollectionReference collectionReference;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String urlCapa = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String urlAvatar = "";
    @org.jetbrains.annotations.NotNull()
    private android.os.CountDownTimer clock;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> timer = null;
    private long timeLeftInMili = 150000L;
    private boolean timeRunning = false;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> carregandoPergunta;
    private final java.lang.String apiKey = "2ae684da617a0a9eb2d4bd28815050e8";
    private final java.lang.String IDIOMA = "pt-BR";
    private final double POPULARIDADE_MINIMA = 2.0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Configuracoes> configuracoes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> emailUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> facebookIsLogged = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> googleIsLogged = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.google.firebase.auth.FirebaseAuth> auth = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.google.android.gms.auth.api.signin.GoogleSignInClient> googleSignInClient = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> jaTemUsername = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> usernameCriado = null;
    private boolean modoSobrevivencia = false;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> recordeSobrevivencia;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> recordeTimeLimit;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.projetointegrador.domain.Genero>> getListGeneros() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.util.ArrayList<com.example.projetointegrador.domain.Jogador>>> getPagesRanking() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Genres> getListGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Filme> getFilmeSugestion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Crew> getCrewSugestion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.projetointegrador.domain.Filme> getListSugestion() {
        return null;
    }
    
    public final void setListSugestion(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.projetointegrador.domain.Filme> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getLastMovieId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getListTemplates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Pergunta> getPergunta() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getAcertos() {
        return null;
    }
    
    public final void setAcertos(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Object>> getJogadorLogado() {
        return null;
    }
    
    public final void setJogadorLogado(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.Object>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    public final void setFirebaseAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getDbFirestore() {
        return null;
    }
    
    public final void setDbFirestore(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.CollectionReference getCollectionReference() {
        return null;
    }
    
    public final void setCollectionReference(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.CollectionReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrlCapa() {
        return null;
    }
    
    public final void setUrlCapa(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrlAvatar() {
        return null;
    }
    
    public final void setUrlAvatar(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.CountDownTimer getClock() {
        return null;
    }
    
    public final void setClock(@org.jetbrains.annotations.NotNull()
    android.os.CountDownTimer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getTimer() {
        return null;
    }
    
    public final long getTimeLeftInMili() {
        return 0L;
    }
    
    public final void setTimeLeftInMili(long p0) {
    }
    
    public final boolean getTimeRunning() {
        return false;
    }
    
    public final void setTimeRunning(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getCarregandoPergunta() {
        return null;
    }
    
    public final void setCarregandoPergunta(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Configuracoes> getConfiguracoes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getEmailUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFacebookIsLogged() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getGoogleIsLogged() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.google.firebase.auth.FirebaseAuth> getAuth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.google.android.gms.auth.api.signin.GoogleSignInClient> getGoogleSignInClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getJaTemUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getUsernameCriado() {
        return null;
    }
    
    public final boolean getModoSobrevivencia() {
        return false;
    }
    
    public final void setModoSobrevivencia(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getRecordeSobrevivencia() {
        return null;
    }
    
    public final void setRecordeSobrevivencia(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getRecordeTimeLimit() {
        return null;
    }
    
    public final void setRecordeTimeLimit(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    public final void verificarSeTemUsername() {
    }
    
    public final void criarUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String userName) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> getDadosJogador(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String bio, int recordeTimeLimit, int recordeSobrevivencia, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> generosFavoritos, @org.jetbrains.annotations.NotNull()
    java.lang.String urlAvatar, @org.jetbrains.annotations.NotNull()
    java.lang.String urlCapa) {
        return null;
    }
    
    public final void getDadosJogadorLogado() {
    }
    
    public final void sendJogador(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> jogador) {
    }
    
    public final void updateJogador(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> jogador) {
    }
    
    public final void updateCapa(@org.jetbrains.annotations.NotNull()
    java.lang.String urlCapa) {
    }
    
    public final void updateAvatar(@org.jetbrains.annotations.NotNull()
    java.lang.String urlAvatar) {
    }
    
    public final void popListGeneros() {
    }
    
    public final void getCurrentRecorde() {
    }
    
    public final void updateLastMovieId() {
    }
    
    public final void popListGenres() {
    }
    
    public final void getFilmeSugestion() {
    }
    
    public final void gerarPerguntaAleatoria() {
    }
    
    private final java.util.ArrayList<com.example.projetointegrador.domain.Genero> getAllGeneros() {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> popTemplates() {
        return null;
    }
    
    public final void atualizarAcertos(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, int acertos) {
    }
    
    public final void popAlternativas(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatButton[] listBotoes) {
    }
    
    public final void initializeOfflineTemplates() {
    }
    
    public final void carregarConfiguracoes(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void getConfigurationForUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void createConfigurationForUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void updateConfiguracoes(boolean isChecked, @org.jetbrains.annotations.NotNull()
    java.lang.String campo) {
    }
    
    public final void atualizarEmailUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void updateFacebookLogIn(boolean isLogged) {
    }
    
    public final int onAcerto() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String acertoSingularOuPlural() {
        return null;
    }
    
    public final void startTimer() {
    }
    
    public final void stopTimer() {
    }
    
    public final void startStopTimer() {
    }
    
    public final void updateTimer() {
    }
    
    public final boolean novoRecorde(@org.jetbrains.annotations.NotNull()
    java.lang.String sobrevivenciaOuTimeLimit) {
        return false;
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.Repository repositorys, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.DBRepository dbRepository) {
        super();
    }
}