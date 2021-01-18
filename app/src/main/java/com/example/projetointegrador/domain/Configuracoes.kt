package com.example.projetointegrador.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configuracoes")
data class Configuracoes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val email: String,
    val vibrar: Boolean,
    val notificacoes: Boolean
)

