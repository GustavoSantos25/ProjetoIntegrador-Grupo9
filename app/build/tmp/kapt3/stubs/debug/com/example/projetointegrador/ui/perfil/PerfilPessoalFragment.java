package com.example.projetointegrador.ui.perfil;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\"\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J$\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0006\u0010.\u001a\u00020 J\u0006\u0010/\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00060"}, d2 = {"Lcom/example/projetointegrador/ui/perfil/PerfilPessoalFragment;", "Landroidx/fragment/app/Fragment;", "()V", "CODE_IMG_CAPA", "", "COD_IMG_AVATAR", "adapter", "Lcom/example/projetointegrador/adapters/GenerosAdapter;", "getAdapter", "()Lcom/example/projetointegrador/adapters/GenerosAdapter;", "setAdapter", "(Lcom/example/projetointegrador/adapters/GenerosAdapter;)V", "alertImg", "Landroid/app/AlertDialog;", "binding", "Lcom/example/projetointegrador/databinding/FragmentPerfilPessoalBinding;", "listGeneros", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Genero;", "getListGeneros", "()Ljava/util/ArrayList;", "setListGeneros", "(Ljava/util/ArrayList;)V", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "viewModel", "Lcom/example/projetointegrador/ui/MainViewModel;", "getViewModel", "()Lcom/example/projetointegrador/ui/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "editarBio", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setIntentAvatar", "setIntentCapa", "app_debug"})
public final class PerfilPessoalFragment extends androidx.fragment.app.Fragment {
    private com.example.projetointegrador.databinding.FragmentPerfilPessoalBinding binding;
    private android.app.AlertDialog alertImg;
    private com.google.firebase.storage.StorageReference storageReference;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.projetointegrador.domain.Genero> listGeneros;
    @org.jetbrains.annotations.NotNull()
    private com.example.projetointegrador.adapters.GenerosAdapter adapter;
    private final int CODE_IMG_CAPA = 1000;
    private final int COD_IMG_AVATAR = 1001;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.projetointegrador.domain.Genero> getListGeneros() {
        return null;
    }
    
    public final void setListGeneros(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.projetointegrador.domain.Genero> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.adapters.GenerosAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.adapters.GenerosAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.ui.MainViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void setIntentCapa() {
    }
    
    public final void setIntentAvatar() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void editarBio() {
    }
    
    public PerfilPessoalFragment() {
        super();
    }
}