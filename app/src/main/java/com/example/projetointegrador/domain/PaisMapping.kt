package com.example.projetointegrador.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paismapping")
data class PaisMapping(
    @PrimaryKey
    val id: Int = 0,
    val nomePortugues: String,
    val nomeIngles: String
)