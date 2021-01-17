package com.example.projetointegrador.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.projetointegrador.domain.FilmeReplace

interface FilmeReplaceDAO {

    @Insert
    suspend fun addFilmeReplace(filmeReplace: FilmeReplace)

    @Query("SELECT * FROM FILMES")
    suspend fun getAllFilmesReplace(): List<FilmeReplace>
}