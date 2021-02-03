package com.example.projetointegrador.domain

data class Genre(val id: Int, val name: String)

data class Genres(val genres: ArrayList<Genre>)

data class Filme(
    val backdrop_path : String,
    val genres: ArrayList<Genre>,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val production_countries: ArrayList<ProductionCountries>,
    val tagline: String
)

data class Sugestions(var results : ArrayList<Filme>)

data class Producer(val name : String, val profile_path : String, val job : String)

data class Crew(val crew : ArrayList<Producer>)

data class ProductionCountries(val name: String)

data class Credits(
    val cast: List<Cast>,
    val crew: List<CrewCredits>,
    val id: Int
)

data class Cast(
    val adult: Boolean,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: Any
)

data class CrewCredits(
    val adult: Boolean,
    val credit_id: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)