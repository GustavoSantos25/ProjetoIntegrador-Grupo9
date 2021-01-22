package com.example.projetointegrador.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/example/projetointegrador/services/DBRepositoryImplementation;", "Lcom/example/projetointegrador/services/DBRepository;", "templateDAO", "Lcom/example/projetointegrador/dao/TemplateDAO;", "filmeReplaceDAO", "Lcom/example/projetointegrador/dao/FilmeReplaceDAO;", "configuracoesDAO", "Lcom/example/projetointegrador/dao/ConfiguracoesDAO;", "(Lcom/example/projetointegrador/dao/TemplateDAO;Lcom/example/projetointegrador/dao/FilmeReplaceDAO;Lcom/example/projetointegrador/dao/ConfiguracoesDAO;)V", "getConfiguracoesDAO", "()Lcom/example/projetointegrador/dao/ConfiguracoesDAO;", "getFilmeReplaceDAO", "()Lcom/example/projetointegrador/dao/FilmeReplaceDAO;", "getTemplateDAO", "()Lcom/example/projetointegrador/dao/TemplateDAO;", "addConfiguracoesTask", "", "configuracoes", "Lcom/example/projetointegrador/domain/Configuracoes;", "(Lcom/example/projetointegrador/domain/Configuracoes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFilmesReplaceTask", "", "Lcom/example/projetointegrador/domain/FilmeReplace;", "filmeReplace", "(Lcom/example/projetointegrador/domain/FilmeReplace;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTemplateTask", "Lcom/example/projetointegrador/domain/Template;", "template", "(Lcom/example/projetointegrador/domain/Template;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllConfiguracoesTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFilmesReplaceTask", "getAllTemplatesTask", "getConfiguracoesForUserTask", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfiguracoesTask", "app_debug"})
public final class DBRepositoryImplementation implements com.example.projetointegrador.services.DBRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.TemplateDAO templateDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.FilmeReplaceDAO filmeReplaceDAO = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.dao.ConfiguracoesDAO configuracoesDAO = null;
    
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
    public java.lang.Object updateConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Configuracoes configuracoes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Configuracoes> p1) {
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
    
    public DBRepositoryImplementation(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.TemplateDAO templateDAO, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.FilmeReplaceDAO filmeReplaceDAO, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.dao.ConfiguracoesDAO configuracoesDAO) {
        super();
    }
}