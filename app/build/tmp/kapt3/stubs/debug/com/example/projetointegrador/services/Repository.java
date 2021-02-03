package com.example.projetointegrador.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\f\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00122\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J/\u0010\u0017\u001a\u00020\u00122\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ/\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ9\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/example/projetointegrador/services/Repository;", "", "idMovie", "", "getIdMovie", "()Ljava/lang/String;", "setIdMovie", "(Ljava/lang/String;)V", "getCrewMovieSugestionRepo", "Lcom/example/projetointegrador/domain/Crew;", "movieId", "", "api_key", "language", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCrewSugestionRepo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilmeSugestionRepo", "Lcom/example/projetointegrador/domain/Filme;", "getGenerosRepo", "Lcom/example/projetointegrador/domain/Genres;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastMovieInApi", "getMovieById", "getMovieCredits", "Lcom/example/projetointegrador/domain/Credits;", "getSugestionMovieRepo", "Lcom/example/projetointegrador/domain/Sugestions;", "sort_by", "with_genres", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface Repository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getIdMovie();
    
    public abstract void setIdMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "genre/movie/list")
    public abstract java.lang.Object getGenerosRepo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Genres> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/24")
    public abstract java.lang.Object getFilmeSugestionRepo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Filme> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/24/credits")
    public abstract java.lang.Object getCrewSugestionRepo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Crew> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "discover/movie")
    public abstract java.lang.Object getSugestionMovieRepo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort_by")
    java.lang.String sort_by, @retrofit2.http.Query(value = "with_genres")
    int with_genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Sugestions> p4);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/{movie_id}/credits")
    public abstract java.lang.Object getCrewMovieSugestionRepo(@retrofit2.http.Path(value = "movie_id")
    int movieId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Crew> p3);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/latest")
    public abstract java.lang.Object getLastMovieInApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "languge")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Filme> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/{movie_id}")
    public abstract java.lang.Object getMovieById(@retrofit2.http.Path(value = "movie_id")
    int movieId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Filme> p3);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/{movie_id}/credits")
    public abstract java.lang.Object getMovieCredits(@retrofit2.http.Path(value = "movie_id")
    int movieId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.projetointegrador.domain.Credits> p3);
}