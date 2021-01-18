package com.example.projetointegrador.dao

import androidx.room.*
import com.example.projetointegrador.domain.Configuracoes

@Dao
interface ConfiguracoesDAO {

    //@Insert
    //suspend fun addConfiguracoes(configuracoes: Configuracoes)

    @Query ("SELECT * FROM configuracoes")
    suspend fun getAllConfiguracoes(): List<Configuracoes>

    @Query ("SELECT * FROM configuracoes WHERE email = :aEmail")
    suspend fun getConfiguracoesForUser(aEmail: String): Configuracoes

    @Update
    suspend fun updateConfiguracoes(configuracoes: Configuracoes)

}