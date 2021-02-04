package com.example.projetointegrador.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projetointegrador.domain.PaisMapping

@Dao
interface PaisMappingDAO {

    @Insert
    suspend fun populatePaisesMapping(paises: List<PaisMapping>)

    @Insert
    suspend fun addPais(pais: PaisMapping)

    @Query ("SELECT nomePortugues FROM paismapping WHERE nomeIngles like :country")
    suspend fun getPaisPortugues(country: String): String

    @Query ("SELECT max(id) FROM paismapping")
    suspend fun testIsEmpty(): Int
}