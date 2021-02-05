package com.example.projetointegrador.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012,\u0010\u0007\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\n\u00a2\u0006\u0002\u0010\u000bJ4\u0010\u0012\u001a\u00020\u00132,\u0010\u0014\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\nJ \u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R4\u0010\u0007\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/projetointegrador/adapters/RankingAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/example/projetointegrador/adapters/JogadorRankingAdapter$OnClickJogadorListener;", "context", "Landroid/content/Context;", "viewModel", "Lcom/example/projetointegrador/ui/MainViewModel;", "listRanking", "Ljava/util/ArrayList;", "Lcom/example/projetointegrador/domain/Jogador;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/example/projetointegrador/ui/MainViewModel;Ljava/util/ArrayList;)V", "listTitles", "", "getListTitles", "()Ljava/util/ArrayList;", "setListTitles", "(Ljava/util/ArrayList;)V", "addAll", "", "list", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getPageTitle", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "onClickJogador", "app_debug"})
public final class RankingAdapter extends androidx.viewpager.widget.PagerAdapter implements com.example.projetointegrador.adapters.JogadorRankingAdapter.OnClickJogadorListener {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> listTitles;
    private final android.content.Context context = null;
    private final com.example.projetointegrador.ui.MainViewModel viewModel = null;
    private java.util.ArrayList<java.util.ArrayList<com.example.projetointegrador.domain.Jogador>> listRanking;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getListTitles() {
        return null;
    }
    
    public final void setListTitles(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isViewFromObject(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
        return false;
    }
    
    @java.lang.Override()
    public void destroyItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.CharSequence getPageTitle(int position) {
        return null;
    }
    
    public final void addAll(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.util.ArrayList<com.example.projetointegrador.domain.Jogador>> list) {
    }
    
    @java.lang.Override()
    public void onClickJogador(int position) {
    }
    
    public RankingAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.projetointegrador.ui.MainViewModel viewModel, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.util.ArrayList<com.example.projetointegrador.domain.Jogador>> listRanking) {
        super();
    }
}