package com.example.projetointegrador.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u001eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001d2\u0006\u0010#\u001a\u00020\"H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0019\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0019\u0010.\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/example/projetointegrador/services/DBRepositoryImplementation;", "Lcom/example/projetointegrador/services/DBRepository;", "templateDAO", "Lcom/example/projetointegrador/dao/TemplateDAO;", "filmeReplaceDAO", "Lcom/example/projetointegrador/dao/FilmeReplaceDAO;", "configuracoesDAO", "Lcom/example/projetointegrador/dao/ConfiguracoesDAO;", "filmeSugestaoDAO", "Lcom/example/projetointegrador/dao/FilmeSugestaoDAO;", "(Lcom/example/projetointegrador/dao/TemplateDAO;Lcom/example/projetointegrador/dao/FilmeReplaceDAO;Lcom/example/projetointegrador/dao/ConfiguracoesDAO;Lcom/example/projetointegrador/dao/FilmeSugestaoDAO;)V", "getConfiguracoesDAO", "()Lcom/example/projetointegrador/dao/ConfiguracoesDAO;", "getFilmeReplaceDAO", "()Lcom/example/projetointegrador/dao/FilmeReplaceDAO;", "getFilmeSugestaoDAO", "()Lcom/example/projetointegrador/dao/FilmeSugestaoDAO;", "getTemplateDAO", "()Lcom/example/projetointegrador/dao/TemplateDAO;", "addConfiguracoesTask", "", "configuracoes", "Lcom/example/projetointegrador/domain/Configuracoes;", "(Lcom/example/projetointegrador/domain/Configuracoes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFilmeSugestaoTask", "filmeSug", "Lcom/example/projetointegrador/domain/FilmeSugestion;", "(Lcom/example/projetointegrador/domain/FilmeSugestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFilmesReplaceTask", "", "Lcom/example/projetointegrador/domain/FilmeReplace;", "filmeReplace", "(Lcom/example/projetointegrador/domain/FilmeReplace;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTemplateTask", "Lcom/example/projetointegrador/domain/Template;", "template", "(Lcom/example/projetointegrador/domain/Template;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllConfiguracoesTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFilmesReplaceTask", "getAllTemplatesTask", "getConfiguracoesForUserTask", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilmeSugestaoTask", "updateConfiguracoesTask", "updateFilmeSugestaoTask", "filme", "app_debug"})
public final class DBRepositoryImplementation implements com.example.projetointegrador.services.DBRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.TemplateDAO templateDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.FilmeReplaceDAO filmeReplaceDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.ConfiguracoesDAO configuracoesDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.FilmeSugestaoDAO filmeSugestaoDAO = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addTemplateTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Template template, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Template>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addFilmesReplaceTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.FilmeReplace filmeReplace, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.FilmeReplace>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Configuracoes configuracoes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addFilmeSugestaoTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.FilmeSugestion filmeSug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAllTemplatesTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Template>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAllFilmesReplaceTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.FilmeReplace>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getAllConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Configuracoes>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getConfiguracoesForUserTask(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Configuracoes> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getFilmeSugestaoTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.FilmeSugestion> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Configuracoes configuracoes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Configuracoes> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateFilmeSugestaoTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.FilmeSugestion filme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.FilmeSugestion> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.dao.TemplateDAO getTemplateDAO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.dao.FilmeReplaceDAO getFilmeReplaceDAO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.dao.ConfiguracoesDAO getConfiguracoesDAO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.dao.FilmeSugestaoDAO getFilmeSugestaoDAO() {
        return null;
    }
    
    public DBRepositoryImplementation(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.TemplateDAO templateDAO, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.FilmeReplaceDAO filmeReplaceDAO, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.ConfiguracoesDAO configuracoesDAO, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.FilmeSugestaoDAO filmeSugestaoDAO) {
        super();
    }
}