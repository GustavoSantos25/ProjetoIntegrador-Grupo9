package com.example.projetointegrador.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"dbApp", "Lcom/example/projetointegrador/database/AppDataBase;", "getDbApp", "()Lcom/example/projetointegrador/database/AppDataBase;", "setDbApp", "(Lcom/example/projetointegrador/database/AppDataBase;)V", "dbRepository", "Lcom/example/projetointegrador/services/DBRepository;", "getDbRepository", "()Lcom/example/projetointegrador/services/DBRepository;", "setDbRepository", "(Lcom/example/projetointegrador/services/DBRepository;)V", "notifications", "", "getNotifications", "()Z", "setNotifications", "(Z)V", "app_debug"})
public final class DBServicesKt {
    @org.jetbrains.annotations.NotNull()
    public static com.example.projetointegrador.database.AppDataBase dbApp;
    @org.jetbrains.annotations.NotNull()
    public static com.example.projetointegrador.services.DBRepository dbRepository;
    private static boolean notifications = false;
    
    @org.jetbrains.annotations.NotNull()
    public static final com.example.projetointegrador.database.AppDataBase getDbApp() {
        return null;
    }
    
    public static final void setDbApp(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.database.AppDataBase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.example.projetointegrador.services.DBRepository getDbRepository() {
        return null;
    }
    
    public static final void setDbRepository(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.services.DBRepository p0) {
    }
    
    public static final boolean getNotifications() {
        return false;
    }
    
    public static final void setNotifications(boolean p0) {
    }
}