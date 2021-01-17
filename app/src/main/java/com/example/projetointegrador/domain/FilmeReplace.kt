package com.example.projetointegrador.domain

import androidx.room.Entity

@Entity(tableName = "filmes")
data class FilmeReplace(
    val id: Int,
    val nome: String,
    val pais: String,
    val dataLancamento: String,
    val diretor: String
)
