package com.example.projetointegrador.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filmes")
data class FilmeReplace(
    @PrimaryKey
    val id: Int,
    val nome: String,
    val pais: String,
    val dataLancamento: String,
    val diretor: String
)
