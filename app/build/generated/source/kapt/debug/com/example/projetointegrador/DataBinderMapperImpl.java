package com.example.projetointegrador;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.projetointegrador.databinding.ActivityCadastroBindingImpl;
import com.example.projetointegrador.databinding.ActivityLoginBindingImpl;
import com.example.projetointegrador.databinding.FragmentConfiguracoesBindingImpl;
import com.example.projetointegrador.databinding.FragmentPerguntaBindingImpl;
import com.example.projetointegrador.databinding.FragmentResultadoBindingImpl;
import com.example.projetointegrador.databinding.FragmentSobrevivenciaBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCADASTRO = 1;

  private static final int LAYOUT_ACTIVITYLOGIN = 2;

  private static final int LAYOUT_FRAGMENTCONFIGURACOES = 3;

  private static final int LAYOUT_FRAGMENTPERGUNTA = 4;

  private static final int LAYOUT_FRAGMENTRESULTADO = 5;

  private static final int LAYOUT_FRAGMENTSOBREVIVENCIA = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.activity_cadastro, LAYOUT_ACTIVITYCADASTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_configuracoes, LAYOUT_FRAGMENTCONFIGURACOES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_pergunta, LAYOUT_FRAGMENTPERGUNTA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_resultado, LAYOUT_FRAGMENTRESULTADO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_sobrevivencia, LAYOUT_FRAGMENTSOBREVIVENCIA);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCADASTRO: {
          if ("layout/activity_cadastro_0".equals(tag)) {
            return new ActivityCadastroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_cadastro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCONFIGURACOES: {
          if ("layout/fragment_configuracoes_0".equals(tag)) {
            return new FragmentConfiguracoesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_configuracoes is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPERGUNTA: {
          if ("layout/fragment_pergunta_0".equals(tag)) {
            return new FragmentPerguntaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_pergunta is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRESULTADO: {
          if ("layout/fragment_resultado_0".equals(tag)) {
            return new FragmentResultadoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_resultado is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSOBREVIVENCIA: {
          if ("layout/fragment_sobrevivencia_0".equals(tag)) {
            return new FragmentSobrevivenciaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sobrevivencia is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_cadastro_0", com.example.projetointegrador.R.layout.activity_cadastro);
      sKeys.put("layout/activity_login_0", com.example.projetointegrador.R.layout.activity_login);
      sKeys.put("layout/fragment_configuracoes_0", com.example.projetointegrador.R.layout.fragment_configuracoes);
      sKeys.put("layout/fragment_pergunta_0", com.example.projetointegrador.R.layout.fragment_pergunta);
      sKeys.put("layout/fragment_resultado_0", com.example.projetointegrador.R.layout.fragment_resultado);
      sKeys.put("layout/fragment_sobrevivencia_0", com.example.projetointegrador.R.layout.fragment_sobrevivencia);
    }
  }
}
