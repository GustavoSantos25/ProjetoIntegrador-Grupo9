// Generated by data binding compiler. Do not edit!
package com.example.projetointegrador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.projetointegrador.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentResultadoBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnCompartilharVitoria;

  @NonNull
  public final AppCompatButton btnTelaInicialResultado;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ImageView ivTrofeu;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout llLogo;

  @NonNull
  public final TextView tvQtdeAcertosResultado;

  protected FragmentResultadoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnCompartilharVitoria, AppCompatButton btnTelaInicialResultado,
      ImageView imageView4, ImageView ivTrofeu, LinearLayout linearLayout, LinearLayout llLogo,
      TextView tvQtdeAcertosResultado) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCompartilharVitoria = btnCompartilharVitoria;
    this.btnTelaInicialResultado = btnTelaInicialResultado;
    this.imageView4 = imageView4;
    this.ivTrofeu = ivTrofeu;
    this.linearLayout = linearLayout;
    this.llLogo = llLogo;
    this.tvQtdeAcertosResultado = tvQtdeAcertosResultado;
  }

  @NonNull
  public static FragmentResultadoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_resultado, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentResultadoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentResultadoBinding>inflateInternal(inflater, R.layout.fragment_resultado, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentResultadoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_resultado, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentResultadoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentResultadoBinding>inflateInternal(inflater, R.layout.fragment_resultado, null, false, component);
  }

  public static FragmentResultadoBinding bind(@NonNull View view) {
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
  public static FragmentResultadoBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentResultadoBinding)bind(component, view, R.layout.fragment_resultado);
  }
}
