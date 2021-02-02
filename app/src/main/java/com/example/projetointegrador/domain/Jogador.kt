package com.example.projetointegrador.domain

data class Jogador(
    var uid: String = "",
    var userName: String = "",
    var recordeTimeLimit: Int = 0,
    var recordeSobrevivencia: Int = 0,
    var generosFavoritos: ArrayList<Int> = ArrayList(),
    var urlAvatar: String = "",
    var urlCapa: String = ""
)