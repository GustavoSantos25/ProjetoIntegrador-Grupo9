package com.example.projetointegrador.services

import com.example.projetointegrador.domain.*
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
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
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Crew

    @GET("discover/movie")
    suspend fun getSugestionMovieRepo(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("sort_by") sort_by: String,
        @Query("with_genres") with_genres: Int
    ) : Sugestions

    @GET("movie/{movie_id}/credits")
    suspend fun getCrewMovieSugestionRepo(
        @Path("movie_id") movieId : Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Crew

    @GET("movie/latest")
    suspend fun getLastMovieInApi(
        @Query("api_key") api_key: String,
        @Query("languge") language: String
    ): Filme



    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Filme

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Credits
}

const val url = "https://api.themoviedb.org/3/"


val retrofit = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)