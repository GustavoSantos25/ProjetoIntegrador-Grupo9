package com.example.projetointegrador.domain

data class Jogador(
    var uid: String,
    var userName: String,
    var recordeTimeLimit: Int,
    var recordeSobrevivencia: Int,
    var generosFavoritos: ArrayList<Int>,
    var urlAvatar: String,
    var urlCapa: String
)