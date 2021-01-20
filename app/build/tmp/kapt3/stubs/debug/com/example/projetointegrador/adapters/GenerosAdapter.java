package com.example.projetointegrador.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/projetointegrador/adapters/GenerosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/projetointegrador/adapters/GenerosAdapter$GenerosViewHolder;", "listaGeneros", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Genero;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "addAll", "", "list", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GenerosViewHolder", "app_debug"})
public final class GenerosAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.projetointegrador.adapters.GenerosAdapter.GenerosViewHolder> {
    private final java.util.ArrayList<com.example.projetointegrador.domain.Genero> listaGeneros = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.projetointegrador.adapters.GenerosAdapter.GenerosViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.adapters.GenerosAdapter.GenerosViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final boolean addAll(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.projetointegrador.domain.Genero> list) {
        return false;
    }
    
    public GenerosAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.projetointegrador.domain.Genero> listaGeneros) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/example/projetointegrador/adapters/GenerosAdapter$GenerosViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/example/projetointegrador/adapters/GenerosAdapter;Landroid/view/View;)V", "ivGenero", "Landroid/widget/ImageView;", "getIvGenero", "()Landroid/widget/ImageView;", "setIvGenero", "(Landroid/widget/ImageView;)V", "tvNomeGenero", "Landroid/widget/TextView;", "getTvNomeGenero", "()Landroid/widget/TextView;", "setTvNomeGenero", "(Landroid/widget/TextView;)V", "onClick", "", "v", "app_debug"})
    public final class GenerosViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView ivGenero;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tvNomeGenero;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIvGenero() {
            return null;
        }
        
        public final void setIvGenero(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvNomeGenero() {
            return null;
        }
        
        public final void setTvNomeGenero(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        public GenerosViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}