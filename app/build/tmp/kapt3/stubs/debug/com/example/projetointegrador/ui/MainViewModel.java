package com.example.projetointegrador.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020\bJ\u000e\u0010E\u001a\u00020@2\u0006\u0010D\u001a\u00020\bJ\u000e\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020\u0012J\u000e\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020&J\u000e\u0010J\u001a\u00020@2\u0006\u0010D\u001a\u00020\bJ\u0006\u0010K\u001a\u00020@J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u000e\u0010M\u001a\u00020@2\u0006\u0010D\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020@J\u0006\u0010N\u001a\u00020@J\u0006\u0010O\u001a\u00020\bJ\u0019\u0010P\u001a\u00020@2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R\u00a2\u0006\u0002\u0010TJ\u0006\u0010U\u001a\u00020@J\u0006\u0010V\u001a\u00020@J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0+H\u0002J\u0019\u0010X\u001a\u00020@2\u0006\u0010Y\u001a\u00020=H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010ZJ\u0019\u0010[\u001a\u00020@2\u0006\u0010Y\u001a\u00020=H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010ZJ\u0019\u0010\\\u001a\u00020@2\u0006\u0010Y\u001a\u00020=H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010ZJ\u0019\u0010]\u001a\u00020@2\u0006\u0010Y\u001a\u00020=H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010ZJ\u0016\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020\bJ\u000e\u0010a\u001a\u00020@2\u0006\u0010b\u001a\u00020\u001eJ\u000e\u0010c\u001a\u00020@2\u0006\u0010b\u001a\u00020\u001eJ\u0006\u0010d\u001a\u00020@R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0014R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0014R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0014R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\b0+\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R#\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0+0+0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0014R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006e"}, d2 = {"Lcom/example/projetointegrador/ui/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repositorys", "Lcom/example/projetointegrador/services/Repository;", "dbRepository", "Lcom/example/projetointegrador/services/DBRepository;", "(Lcom/example/projetointegrador/services/Repository;Lcom/example/projetointegrador/services/DBRepository;)V", "IDIOMA", "", "acertos", "", "getAcertos", "()I", "setAcertos", "(I)V", "apiKey", "auth", "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Landroidx/lifecycle/MutableLiveData;", "configuracoes", "Lcom/example/projetointegrador/domain/Configuracoes;", "getConfiguracoes", "crewSugestion", "Lcom/example/projetointegrador/domain/Crew;", "getCrewSugestion", "emailUser", "getEmailUser", "facebookIsLogged", "", "getFacebookIsLogged", "filmeSugestion", "Lcom/example/projetointegrador/domain/Filme;", "getFilmeSugestion", "googleIsLogged", "getGoogleIsLogged", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "lastMovieId", "getLastMovieId", "listGeneros", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Genero;", "getListGeneros", "listGenres", "Lcom/example/projetointegrador/domain/Genres;", "getListGenres", "listTemplates", "getListTemplates", "()Ljava/util/ArrayList;", "modoSobrevivencia", "getModoSobrevivencia", "()Z", "setModoSobrevivencia", "(Z)V", "pagesRanking", "Lcom/example/projetointegrador/domain/Jogador;", "getPagesRanking", "pergunta", "Lcom/example/projetointegrador/domain/Pergunta;", "getPergunta", "atualizarAcertos", "", "textView", "Landroid/widget/TextView;", "atualizarEmailUser", "email", "carregarConfiguracoes", "configFacebook", "fauth", "configGoogle", "gclient", "createConfigurationForUser", "gerarPerguntaAleatoria", "getAllGeneros", "getConfigurationForUser", "initializeOfflineTemplates", "onAcerto", "popAlternativas", "listBotoes", "", "Landroidx/appcompat/widget/AppCompatButton;", "([Landroidx/appcompat/widget/AppCompatButton;)V", "popListGeneros", "popListGenres", "popTemplates", "primeiroTemplate", "perguntaGerada", "(Lcom/example/projetointegrador/domain/Pergunta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quartoTemplate", "segundoTemplate", "terceiroTemplate", "updateConfigura\u00e7\u00f5es", "isChecked", "campo", "updateFacebookLogIn", "isLogged", "updateGoogleLogIn", "updateLastMovieId", "app_debug"})
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
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> lastMovieId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> listTemplates = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.projetointegrador.domain.Pergunta> pergunta = null;
    private int acertos = 0;
    private final java.lang.String apiKey = "2ae684da617a0a9eb2d4bd28815050e8";
    private final java.lang.String IDIOMA = "pt-BR";
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
    private boolean modoSobrevivencia = false;
    
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
    
    public final int getAcertos() {
        return 0;
    }
    
    public final void setAcertos(int p0) {
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
    
    public final boolean getModoSobrevivencia() {
        return false;
    }
    
    public final void setModoSobrevivencia(boolean p0) {
    }
    
    public final void popListGeneros() {
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
    
    public final void updateConfigurações(boolean isChecked, @org.jetbrains.annotations.NotNull()
    java.lang.String campo) {
    }
    
    public final void atualizarEmailUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void updateFacebookLogIn(boolean isLogged) {
    }
    
    public final void updateGoogleLogIn(boolean isLogged) {
    }
    
    public final void configFacebook(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth fauth) {
    }
    
    public final void configGoogle(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient gclient) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onAcerto() {
        return null;
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.Repository repositorys, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.DBRepository dbRepository) {
        super();
    }
}