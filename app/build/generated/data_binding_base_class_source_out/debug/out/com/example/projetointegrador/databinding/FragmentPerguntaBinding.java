// Generated by data binding compiler. Do not edit!
package com.example.projetointegrador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.projetointegrador.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPerguntaBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnPrimeiraResposta;

  @NonNull
  public final AppCompatButton btnQuartaResposta;

  @NonNull
  public final AppCompatButton btnSegundaResposta;

  @NonNull
  public final AppCompatButton btnTerceiraResposta;

  @NonNull
  public final CircleImageView civPerguntas;

  @NonNull
  public final CircleImageView civPontos;

  @NonNull
  public final CircleImageView civTempo;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final FrameLayout frameLayout;

  @NonNull
  public final View includeToolbarQuiz;

  @NonNull
  public final TextView tvPergunta;

  @NonNull
  public final View view;

  protected FragmentPerguntaBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnPrimeiraResposta, AppCompatButton btnQuartaResposta,
      AppCompatButton btnSegundaResposta, AppCompatButton btnTerceiraResposta,
      CircleImageView civPerguntas, CircleImageView civPontos, CircleImageView civTempo,
      ConstraintLayout constraintLayout, FrameLayout frameLayout, View includeToolbarQuiz,
      TextView tvPergunta, View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnPrimeiraResposta = btnPrimeiraResposta;
    this.btnQuartaResposta = btnQuartaResposta;
    this.btnSegundaResposta = btnSegundaResposta;
    this.btnTerceiraResposta = btnTerceiraResposta;
    this.civPerguntas = civPerguntas;
    this.civPontos = civPontos;
    this.civTempo = civTempo;
    this.constraintLayout = constraintLayout;
    this.frameLayout = frameLayout;
    this.includeToolbarQuiz = includeToolbarQuiz;
    this.tvPergunta = tvPergunta;
    this.view = view;
  }

  @NonNull
  public static FragmentPerguntaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_pergunta, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPerguntaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPerguntaBinding>inflateInternal(inflater, R.layout.fragment_pergunta, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPerguntaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_pergunta, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPerguntaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPerguntaBinding>inflateInternal(inflater, R.layout.fragment_pergunta, null, false, component);
  }

  public static FragmentPerguntaBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentPerguntaBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPerguntaBinding)bind(component, view, R.layout.fragment_pergunta);
  }
}
