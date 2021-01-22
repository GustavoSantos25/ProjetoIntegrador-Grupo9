package com.example.projetointegrador.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "configuracoes")
data class Configuracoes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    var vibrar: Boolean,
    var notificacoes: Boolean
)

