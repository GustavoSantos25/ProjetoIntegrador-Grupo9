package com.example.projetointegrador.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0006\u0010#\u001a\u00020\u001bJ\"\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+J\u0012\u0010,\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u001bH\u0014J\u000e\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u00063"}, d2 = {"Lcom/example/projetointegrador/ui/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "RC_SIGN_IN", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "Lcom/example/projetointegrador/databinding/ActivityLoginBinding;", "callbackManager", "Lcom/facebook/CallbackManager;", "kotlin.jvm.PlatformType", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "viewModel", "Lcom/example/projetointegrador/ui/MainViewModel;", "getViewModel", "()Lcom/example/projetointegrador/ui/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configFacebookButton", "", "handleFacebookAccessToken", "token", "Lcom/facebook/AccessToken;", "handleSignInResult", "completedTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "initDB", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClickFacebook", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "openHome", "msg", "signIn", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.projetointegrador.databinding.ActivityLoginBinding binding;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private com.google.firebase.auth.FirebaseAuth auth;
    private final com.facebook.CallbackManager callbackManager = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "LOGIN ACTIVITY";
    private int RC_SIGN_IN = 100;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public final com.facebook.CallbackManager getCallbackManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.ui.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void signIn() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void handleSignInResult(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> completedTask) {
    }
    
    public final void openHome(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void initDB() {
    }
    
    public final void configFacebookButton() {
    }
    
    private final void handleFacebookAccessToken(com.facebook.AccessToken token) {
    }
    
    public final void onClickFacebook(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public LoginActivity() {
        super();
    }
}