package com.example.projetointegrador.services

import com.example.projetointegrador.domain.Crew
import com.example.projetointegrador.domain.Filme
import com.example.projetointegrador.domain.Genres
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Repository {

    var idMovie: String

    @GET("genre/movie/list")
    suspend fun getGenerosRepo(
        @Query("api_key") api_key: String
    ): Genres

    @GET("movie/24")
    suspend fun getFilmeSugestionRepo(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Filme

    @GET("movie/24/credits")
    suspend fun getCrewSugestionRepo(
        @Query("api_key") api_key : String,
        @Query("language") language: String
    ) : Crew

    @GET("movie/latest")
    suspend fun getLastMovieInApi(
        @Query("api_key") api_key: String
    ): Filme

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): Filme
}

const val url = "https://api.themoviedb.org/3/"

val retrofit = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)