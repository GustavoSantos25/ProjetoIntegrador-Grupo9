package com.example.projetointegrador.domain

data class Pergunta(
    var enunciado: String = "",
    var genero: String = "",
    var alternativaCerta: String = "",
    var segundaAlternativa: String = "",
    var terceiraAlternativa: String = "",
    var quartaAlternativa: String = ""
)