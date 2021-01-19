package com.example.projetointegrador.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/projetointegrador/dao/ConfiguracoesDAO;", "", "getAllConfiguracoes", "", "Lcom/example/projetointegrador/domain/Configuracoes;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfiguracoesForUser", "aEmail", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfiguracoes", "", "configuracoes", "(Lcom/example/projetointegrador/domain/Configuracoes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ConfiguracoesDAO {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM configuracoes")
    public abstract java.lang.Object getAllConfiguracoes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.projetointegrador.domain.Configuracoes>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM configuracoes WHERE email = :aEmail")
    public abstract java.lang.Object getConfiguracoesForUser(@org.jetbrains.annotations.NotNull()
    java.lang.String aEmail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Configuracoes> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateConfiguracoes(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.Configuracoes configuracoes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}