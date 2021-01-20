package com.example.projetointegrador.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/example/projetointegrador/adapters/JogadorRankingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$JogadorViewHolder;", "listJogadores", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Jogador;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$OnClickJogadorListener;", "(Ljava/util/ArrayList;Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$OnClickJogadorListener;)V", "getListener", "()Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$OnClickJogadorListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "JogadorViewHolder", "OnClickJogadorListener", "app_debug"})
public final class JogadorRankingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.projetointegrador.adapters.JogadorRankingAdapter.JogadorViewHolder> {
    private final java.util.ArrayList<com.example.projetointegrador.domain.Jogador> listJogadores = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.projetointegrador.adapters.JogadorRankingAdapter.OnClickJogadorListener listener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.projetointegrador.adapters.JogadorRankingAdapter.JogadorViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.adapters.JogadorRankingAdapter.JogadorViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.projetointegrador.adapters.JogadorRankingAdapter.OnClickJogadorListener getListener() {
        return null;
    }
    
    public JogadorRankingAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.projetointegrador.domain.Jogador> listJogadores, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.adapters.JogadorRankingAdapter.OnClickJogadorListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$OnClickJogadorListener;", "", "onClickJogador", "", "position", "", "app_debug"})
    public static abstract interface OnClickJogadorListener {
        
        public abstract void onClickJogador(int position);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$JogadorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/example/projetointegrador/adapters/JogadorRankingAdapter;Landroid/view/View;)V", "civAvatarRanking", "Landroid/widget/ImageView;", "getCivAvatarRanking", "()Landroid/widget/ImageView;", "setCivAvatarRanking", "(Landroid/widget/ImageView;)V", "tvAcertosRanking", "Landroid/widget/TextView;", "getTvAcertosRanking", "()Landroid/widget/TextView;", "setTvAcertosRanking", "(Landroid/widget/TextView;)V", "tvNomeJogador", "getTvNomeJogador", "setTvNomeJogador", "onClick", "", "v", "app_debug"})
    public final class JogadorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvNomeJogador;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView civAvatarRanking;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvAcertosRanking;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvNomeJogador() {
            return null;
        }
        
        public final void setTvNomeJogador(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getCivAvatarRanking() {
            return null;
        }
        
        public final void setCivAvatarRanking(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvAcertosRanking() {
            return null;
        }
        
        public final void setTvAcertosRanking(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        public JogadorViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}