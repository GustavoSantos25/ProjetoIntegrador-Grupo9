package com.example.projetointegrador.domain

data class Genre(val id: Int, val name: String)

data class Genres(val genres: ArrayList<Genre>)

data class Filme(
    val genres: ArrayList<Genre>,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val production_countries: ArrayList<ProductionCountries>
)

data class ProductionCountries(val name: String)
