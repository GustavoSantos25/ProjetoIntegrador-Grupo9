package com.example.projetointegrador.services

import com.example.projetointegrador.dao.ConfiguracoesDAO
import com.example.projetointegrador.dao.FilmeReplaceDAO
import com.example.projetointegrador.dao.TemplateDAO
import com.example.projetointegrador.database.AppDataBase
import com.example.projetointegrador.domain.Configuracoes
import com.example.projetointegrador.domain.FilmeReplace
import com.example.projetointegrador.domain.Template

interface DBRepository {

    //inserts
    suspend fun addTemplateTask(template: Template): List<Template>
    suspend fun addFilmesReplaceTask(filmeReplace: FilmeReplace): List<FilmeReplace>
    suspend fun addConfiguracoesTask(configuracoes: Configuracoes)

    //selects
    suspend fun getAllTemplatesTask(): List<Template>
    suspend fun getAllFilmesReplaceTask(): List<FilmeReplace>
    suspend fun getAllConfiguracoesTask(): List<Configuracoes>
    suspend fun getConfiguracoesForUserTask(email: String): Configuracoes

    //updates
    suspend fun updateConfiguracoesTask(configuracoes: Configuracoes): Configuracoes

    //deletes
}

class DBRepositoryImplementation(
    val templateDAO: TemplateDAO, val filmeReplaceDAO: FilmeReplaceDAO,
    val configuracoesDAO: ConfiguracoesDAO
) : DBRepository {

    override suspend fun addTemplateTask(template: Template): List<Template> {
        templateDAO.addTemplateQuestion(template)
        return templateDAO.getAllTemplates()
    }

    override suspend fun addFilmesReplaceTask(filmeReplace: FilmeReplace): List<FilmeReplace> {
        filmeReplaceDAO.addFilmeReplace(filmeReplace)
        return filmeReplaceDAO.getAllFilmesReplace()
    }

    override suspend fun addConfiguracoesTask(configuracoes: Configuracoes) = configuracoesDAO.addConfiguracoes(configuracoes)

    override suspend fun getAllTemplatesTask() = templateDAO.getAllTemplates()

    override suspend fun getAllFilmesReplaceTask() = filmeReplaceDAO.getAllFilmesReplace()

    override suspend fun getAllConfiguracoesTask() = configuracoesDAO.getAllConfiguracoes()

    override suspend fun getConfiguracoesForUserTask(email: String) = configuracoesDAO
        .getConfiguracoesForUser(email)

    override suspend fun updateConfiguracoesTask(configuracoes: Configuracoes): Configuracoes {
        configuracoesDAO.updateConfiguracoes(configuracoes)
        return configuracoesDAO.getConfiguracoesForUser(configuracoes.email)
    }
}

lateinit var dbApp: AppDataBase
lateinit var dbRepository: DBRepository
