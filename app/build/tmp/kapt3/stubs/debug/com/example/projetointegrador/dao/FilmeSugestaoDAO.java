package com.example.projetointegrador.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/projetointegrador/dao/FilmeSugestaoDAO;", "", "addFilmeSugestao", "", "filmeSus", "Lcom/example/projetointegrador/domain/FilmeSugestion;", "(Lcom/example/projetointegrador/domain/FilmeSugestion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilmeSugestao", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFilmeSugestao", "filme", "app_debug"})
public abstract interface FilmeSugestaoDAO {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object addFilmeSugestao(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.FilmeSugestion filmeSus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM filmeSugestao")
    public abstract java.lang.Object getFilmeSugestao(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.FilmeSugestion> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateFilmeSugestao(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.domain.FilmeSugestion filme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}