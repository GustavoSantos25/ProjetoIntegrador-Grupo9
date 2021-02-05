package com.example.projetointegrador.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010&\u001a\u00020\u0018H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/projetointegrador/ui/home/RankingFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$OnClickJogadorListener;", "()V", "adapter", "Lcom/example/projetointegrador/adapters/RankingAdapter;", "getAdapter", "()Lcom/example/projetointegrador/adapters/RankingAdapter;", "setAdapter", "(Lcom/example/projetointegrador/adapters/RankingAdapter;)V", "binding", "Lcom/example/projetointegrador/databinding/FragmentRankingBinding;", "listRankings", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Jogador;", "navController", "Landroidx/navigation/NavController;", "progressView", "Landroid/view/ViewGroup;", "progressoVisivel", "", "viewModel", "Lcom/example/projetointegrador/ui/MainViewModel;", "hideProgressBar", "", "onClickJogador", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "showProgressBar", "app_debug"})
public final class RankingFragment extends androidx.fragment.app.Fragment implements com.example.projetointegrador.adapters.JogadorRankingAdapter.OnClickJogadorListener {
    private com.example.projetointegrador.databinding.FragmentRankingBinding binding;
    private final java.util.ArrayList<java.util.ArrayList<com.example.projetointegrador.domain.Jogador>> listRankings = null;
    private boolean progressoVisivel = false;
    private android.view.ViewGroup progressView;
    @org.jetbrains.annotations.NotNull()
    public com.example.projetointegrador.adapters.RankingAdapter adapter;
    private com.example.projetointegrador.ui.MainViewModel viewModel;
    private androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.adapters.RankingAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.adapters.RankingAdapter p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onClickJogador(int position) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showProgressBar() {
    }
    
    private final void hideProgressBar() {
    }
    
    public RankingFragment() {
        super();
    }
}