package com.example.projetointegrador.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/example/projetointegrador/services/DBRepository;", "", "addConfiguracoesTask", "", "configuracoes", "Lcom/example/projetointegrador/domain/Configuracoes;", "(Lcom/example/projetointegrador/domain/Configuracoes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFilmesReplaceTask", "", "Lcom/example/projetointegrador/domain/FilmeReplace;", "filmeReplace", "(Lcom/example/projetointegrador/domain/FilmeReplace;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTemplateTask", "Lcom/example/projetointegrador/domain/Template;", "template", "(Lcom/example/projetointegrador/domain/Template;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllConfiguracoesTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFilmesReplaceTask", "getAllTemplatesTask", "getConfiguracoesForUserTask", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfiguracoesTask", "app_debug"})
public abstract interface DBRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTemplateTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Template template, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Template>> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addFilmesReplaceTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.FilmeReplace filmeReplace, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.FilmeReplace>> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Configuracoes configuracoes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllTemplatesTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Template>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllFilmesReplaceTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.FilmeReplace>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Configuracoes>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConfiguracoesForUserTask(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Configuracoes> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateConfiguracoesTask(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Configuracoes configuracoes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Configuracoes> p1);
}