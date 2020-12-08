package com.example.projetointegrador.services

import com.example.projetointegrador.domain.Filme
import com.example.projetointegrador.domain.Genre
import com.example.projetointegrador.domain.Genres
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository{
    @GET("genre/movie/list")
    suspend fun getGenerosRepo(
        @Query("api_key") api_key : String
    ) : Genres

    @GET("movie/24")
    suspend fun getFilmeSugestionRepo(
        @Query("api_key") api_key : String,
        @Query("language") language : String
    ) : Filme
}

val url = "https://api.themoviedb.org/3/"

val retrofit = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)