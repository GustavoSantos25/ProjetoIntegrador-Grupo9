package com.example.projetointegrador.domain

data class Genre(val id: Int, val name: String)

data class Genres(val genres: ArrayList<Genre>)

data class Filme(
    val backdrop_path : String,
    val genres: ArrayList<Genre>,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val production_countries: ArrayList<ProductionCountries>
)


data class Producer(val name : String, val profile_path : String, val job : String)

data class Crew(val crew : ArrayList<Producer>)

data class ProductionCountries(val name: String)
