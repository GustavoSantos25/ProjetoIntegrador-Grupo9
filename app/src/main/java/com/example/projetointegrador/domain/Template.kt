package com.example.projetointegrador.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "template")
data class Template(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val perguntaPrimeiraMetade: String,
    val perguntaSegundaMetade: String
    //val tipoDePergunta: Int,
    //val tipoDeResposta: Int
)
