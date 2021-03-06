package com.example.projetointegrador.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projetointegrador.dao.ConfiguracoesDAO
import com.example.projetointegrador.dao.FilmeReplaceDAO
import com.example.projetointegrador.dao.PaisMappingDAO
import com.example.projetointegrador.dao.TemplateDAO
import com.example.projetointegrador.domain.Configuracoes
import com.example.projetointegrador.domain.FilmeReplace
import com.example.projetointegrador.domain.PaisMapping
import com.example.projetointegrador.domain.Template

@Database(entities = [Template::class, FilmeReplace::class, Configuracoes::class, PaisMapping::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun TemplateDAO(): TemplateDAO
    abstract fun FilmeReplaceDAO(): FilmeReplaceDAO
    abstract fun ConfiguracoesDAO(): ConfiguracoesDAO
    abstract fun PaisMappingDAO(): PaisMappingDAO

    companion object {
        @Volatile
        private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "cinefilos.db"
        ).build()
    }
}