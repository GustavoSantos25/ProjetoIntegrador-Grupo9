package com.example.projetointegrador.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\t\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020,J\u0006\u00103\u001a\u00020,J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020&0\u0018H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020&0\u0018H\u0002J\u0006\u0010\u0014\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0006\u00108\u001a\u00020,J\u0019\u00109\u001a\u00020,2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;\u00a2\u0006\u0002\u0010=J\u0006\u0010>\u001a\u00020,J\u0006\u0010?\u001a\u00020,J\u0006\u0010@\u001a\u00020,J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0002J\u0019\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0019\u0010E\u001a\u00020,2\u0006\u0010C\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0019\u0010F\u001a\u00020,2\u0006\u0010C\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0019\u0010G\u001a\u00020,2\u0006\u0010C\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0006\u0010H\u001a\u00020,R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\rR#\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00180\u00180\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\rR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006I"}, d2 = {"Lcom/example/projetointegrador/ui/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repositorys", "Lcom/example/projetointegrador/services/Repository;", "dbRepository", "Lcom/example/projetointegrador/services/DBRepository;", "(Lcom/example/projetointegrador/services/Repository;Lcom/example/projetointegrador/services/DBRepository;)V", "IDIOMA", "", "acertos", "Landroidx/lifecycle/MutableLiveData;", "", "getAcertos", "()Landroidx/lifecycle/MutableLiveData;", "apiKey", "crewSugestion", "Lcom/example/projetointegrador/domain/Crew;", "getCrewSugestion", "filmeSugestion", "Lcom/example/projetointegrador/domain/Filme;", "getFilmeSugestion", "lastMovieId", "getLastMovieId", "listGeneros", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Genero;", "getListGeneros", "listGenres", "Lcom/example/projetointegrador/domain/Genres;", "getListGenres", "listTemplates", "getListTemplates", "()Ljava/util/ArrayList;", "listaConfiguracoes", "", "Lcom/example/projetointegrador/domain/Configuracoes;", "getListaConfiguracoes", "pagesRanking", "Lcom/example/projetointegrador/domain/Jogador;", "getPagesRanking", "pergunta", "Lcom/example/projetointegrador/domain/Pergunta;", "getPergunta", "atualizarAcertos", "", "textView", "Landroid/widget/TextView;", "atualizarGeneroToolbar", "toolbar", "Landroid/widget/Toolbar;", "carregarConfiguracoes", "gerarPerguntaAleatoria", "getAllGeneros", "getAllJogadoresRank1", "getAllJogadoresRank2", "initializeOfflineTemplates", "onProximaPergunta", "popAlternativas", "listBotoes", "", "Landroidx/appcompat/widget/AppCompatButton;", "([Landroidx/appcompat/widget/AppCompatButton;)V", "popListGeneros", "popListGenres", "popPagesRanking", "popTemplates", "primeiroTemplate", "perguntaGerada", "(Lcom/example/projetointegrador/domain/Pergunta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quartoTemplate", "segundoTemplate", "terceiroTemplate", "updateLastMovieId", "app_debug"})
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
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> acertos = null;
    private final java.lang.String apiKey = "2ae684da617a0a9eb2d4bd28815050e8";
    private final java.lang.String IDIOMA = "pt-BR";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.projetointegrador.domain.Configuracoes>> listaConfiguracoes = null;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getAcertos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.projetointegrador.domain.Configuracoes>> getListaConfiguracoes() {
        return null;
    }
    
    public final void popListGeneros() {
    }
    
    public final void popPagesRanking() {
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
    
    private final java.util.ArrayList<com.example.projetointegrador.domain.Jogador> getAllJogadoresRank1() {
        return null;
    }
    
    private final java.util.ArrayList<com.example.projetointegrador.domain.Jogador> getAllJogadoresRank2() {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> popTemplates() {
        return null;
    }
    
    public final void atualizarAcertos(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, int acertos) {
    }
    
    public final void atualizarGeneroToolbar(@org.jetbrains.annotations.NotNull()
    android.widget.Toolbar toolbar) {
    }
    
    public final void popAlternativas(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatButton[] listBotoes) {
    }
    
    public final void onProximaPergunta() {
    }
    
    public final void initializeOfflineTemplates() {
    }
    
    public final void carregarConfiguracoes() {
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.Repository repositorys, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.DBRepository dbRepository) {
        super();
    }
}