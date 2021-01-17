package com.example.projetointegrador.services

import com.example.projetointegrador.dao.FilmeReplaceDAO
import com.example.projetointegrador.dao.TemplateDAO
import com.example.projetointegrador.domain.FilmeReplace
import com.example.projetointegrador.domain.Template

interface DBRepository {
    //inserts
    suspend fun addTemplateTask(template: Template): List<Template>
    //suspend fun addFilmeReplaceTask(filmeReplace: FilmeReplace): List<FilmeReplace>

    //selects
    suspend fun getAllTemplatesTask(): List<Template>
    suspend fun getAllFilmesReplaceTask(): List<FilmeReplace>

    //updates
    //deletes
}

class RepositoryImplementation(val templateDAO: TemplateDAO, val filmeReplaceDAO: FilmeReplaceDAO): DBRepository{

    override suspend fun addTemplateTask(template: Template): List<Template> {
        templateDAO.addTemplateQuestion(template)
        return templateDAO.getAllTemplates()
    }

    override suspend fun addFilmesReplaceTask(filmeReplace: FilmeReplace): List<FilmeReplace> {
        filmeReplaceDAO.addFilmeReplace(filmeReplace)
        return filmeReplaceDAO.getAllFilmesReplace()
    }

    override suspend fun getAllTemplatesTask() = templateDAO.getAllTemplates()

    override suspend fun getAllFilmesReplaceTask() = filmeReplaceDAO.getAllFilmesReplace()
}
