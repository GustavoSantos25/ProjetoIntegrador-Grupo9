package com.example.projetointegrador.database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.projetointegrador.domain.Template.class, com.example.projetointegrador.domain.FilmeReplace.class, com.example.projetointegrador.domain.Configuracoes.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/projetointegrador/database/AppDataBase;", "Landroidx/room/RoomDatabase;", "()V", "ConfiguracoesDAO", "Lcom/example/projetointegrador/dao/ConfiguracoesDAO;", "FilmeReplaceDAO", "Lcom/example/projetointegrador/dao/FilmeReplaceDAO;", "TemplateDAO", "Lcom/example/projetointegrador/dao/TemplateDAO;", "Companion", "app_debug"})
public abstract class AppDataBase extends androidx.room.RoomDatabase {
    private static volatile com.example.projetointegrador.database.AppDataBase instance;
    private static final java.lang.Object LOCK = null;
    public static final com.example.projetointegrador.database.AppDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.projetointegrador.dao.TemplateDAO TemplateDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.projetointegrador.dao.FilmeReplaceDAO FilmeReplaceDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.projetointegrador.dao.ConfiguracoesDAO ConfiguracoesDAO();
    
    public AppDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/projetointegrador/database/AppDataBase$Companion;", "", "()V", "LOCK", "instance", "Lcom/example/projetointegrador/database/AppDataBase;", "buildDatabase", "context", "Landroid/content/Context;", "invoke", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.projetointegrador.database.AppDataBase invoke(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.example.projetointegrador.database.AppDataBase buildDatabase(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}