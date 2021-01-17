package com.example.projetointegrador.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projetointegrador.domain.Template

@Dao
interface TemplateDAO {

    @Insert
    suspend fun addTemplateQuestion(template: Template)

    @Query("SELECT * FROM TEMPLATE")
    suspend fun getAllTemplates(): List<Template>

    //update

    //delete

}