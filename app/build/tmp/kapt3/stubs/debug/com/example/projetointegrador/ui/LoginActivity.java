package com.example.projetointegrador.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\"\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001dH\u0014J\b\u0010.\u001a\u00020\u001dH\u0002J\u0006\u0010/\u001a\u00020\u001dR\u0016\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\n\n\u0002\b\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00061"}, d2 = {"Lcom/example/projetointegrador/ui/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$1", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "Lcom/example/projetointegrador/databinding/ActivityLoginBinding;", "callbackManager", "Lcom/facebook/CallbackManager;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "progressView", "Landroid/view/ViewGroup;", "progressoVisivel", "", "viewModel", "Lcom/example/projetointegrador/ui/MainViewModel;", "getViewModel", "()Lcom/example/projetointegrador/ui/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "firebaseAuthWithGoogle", "", "idToken", "handleFacebookAccessToken", "token", "Lcom/facebook/AccessToken;", "hideProgressBar", "initDB", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "showProgressBar", "signInWithGoogle", "Companion", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.projetointegrador.databinding.ActivityLoginBinding binding;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignOptions;
    private com.google.firebase.auth.FirebaseAuth auth;
    private android.view.ViewGroup progressView;
    private boolean progressoVisivel = false;
    private com.facebook.CallbackManager callbackManager;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG$1 = "LOGIN ACTIVITY";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private static final java.lang.String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    public static final com.example.projetointegrador.ui.LoginActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
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
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void signInWithGoogle() {
    }
    
    private final void firebaseAuthWithGoogle(java.lang.String idToken) {
    }
    
    private final void showProgressBar() {
    }
    
    private final void hideProgressBar() {
    }
    
    private final void initDB() {
    }
    
    private final void handleFacebookAccessToken(com.facebook.AccessToken token) {
    }
    
    public LoginActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/projetointegrador/ui/LoginActivity$Companion;", "", "()V", "RC_SIGN_IN", "", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}