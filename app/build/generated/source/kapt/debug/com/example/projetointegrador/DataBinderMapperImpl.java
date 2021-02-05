package com.example.projetointegrador;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.projetointegrador.databinding.ActivityCadastroBindingImpl;
import com.example.projetointegrador.databinding.ActivityLoginBindingImpl;
import com.example.projetointegrador.databinding.ActivityNewPasswordBindingImpl;
import com.example.projetointegrador.databinding.FragmentConfiguracoesBindingImpl;
import com.example.projetointegrador.databinding.FragmentPerfilPessoalBindingImpl;
import com.example.projetointegrador.databinding.FragmentPerfilTerceiroBindingImpl;
import com.example.projetointegrador.databinding.FragmentPerguntaBindingImpl;
import com.example.projetointegrador.databinding.FragmentRankingBindingImpl;
import com.example.projetointegrador.databinding.FragmentResultadoBindingImpl;
import com.example.projetointegrador.databinding.FragmentSobrevivenciaBindingImpl;
import com.example.projetointegrador.databinding.ProgressbarLayoutBindingImpl;
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

  private static final int LAYOUT_ACTIVITYNEWPASSWORD = 3;

  private static final int LAYOUT_FRAGMENTCONFIGURACOES = 4;

  private static final int LAYOUT_FRAGMENTPERFILPESSOAL = 5;

  private static final int LAYOUT_FRAGMENTPERFILTERCEIRO = 6;

  private static final int LAYOUT_FRAGMENTPERGUNTA = 7;

  private static final int LAYOUT_FRAGMENTRANKING = 8;

  private static final int LAYOUT_FRAGMENTRESULTADO = 9;

  private static final int LAYOUT_FRAGMENTSOBREVIVENCIA = 10;

  private static final int LAYOUT_PROGRESSBARLAYOUT = 11;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(11);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.activity_cadastro, LAYOUT_ACTIVITYCADASTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.activity_new_password, LAYOUT_ACTIVITYNEWPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_configuracoes, LAYOUT_FRAGMENTCONFIGURACOES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_perfil_pessoal, LAYOUT_FRAGMENTPERFILPESSOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_perfil_terceiro, LAYOUT_FRAGMENTPERFILTERCEIRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_pergunta, LAYOUT_FRAGMENTPERGUNTA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_ranking, LAYOUT_FRAGMENTRANKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_resultado, LAYOUT_FRAGMENTRESULTADO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.fragment_sobrevivencia, LAYOUT_FRAGMENTSOBREVIVENCIA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.projetointegrador.R.layout.progressbar_layout, LAYOUT_PROGRESSBARLAYOUT);
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
        case  LAYOUT_ACTIVITYNEWPASSWORD: {
          if ("layout/activity_new_password_0".equals(tag)) {
            return new ActivityNewPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_new_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCONFIGURACOES: {
          if ("layout/fragment_configuracoes_0".equals(tag)) {
            return new FragmentConfiguracoesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_configuracoes is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPERFILPESSOAL: {
          if ("layout/fragment_perfil_pessoal_0".equals(tag)) {
            return new FragmentPerfilPessoalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_perfil_pessoal is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPERFILTERCEIRO: {
          if ("layout/fragment_perfil_terceiro_0".equals(tag)) {
            return new FragmentPerfilTerceiroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_perfil_terceiro is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPERGUNTA: {
          if ("layout/fragment_pergunta_0".equals(tag)) {
            return new FragmentPerguntaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_pergunta is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTRANKING: {
          if ("layout/fragment_ranking_0".equals(tag)) {
            return new FragmentRankingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ranking is invalid. Received: " + tag);
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
        case  LAYOUT_PROGRESSBARLAYOUT: {
          if ("layout/progressbar_layout_0".equals(tag)) {
            return new ProgressbarLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for progressbar_layout is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(11);

    static {
      sKeys.put("layout/activity_cadastro_0", com.example.projetointegrador.R.layout.activity_cadastro);
      sKeys.put("layout/activity_login_0", com.example.projetointegrador.R.layout.activity_login);
      sKeys.put("layout/activity_new_password_0", com.example.projetointegrador.R.layout.activity_new_password);
      sKeys.put("layout/fragment_configuracoes_0", com.example.projetointegrador.R.layout.fragment_configuracoes);
      sKeys.put("layout/fragment_perfil_pessoal_0", com.example.projetointegrador.R.layout.fragment_perfil_pessoal);
      sKeys.put("layout/fragment_perfil_terceiro_0", com.example.projetointegrador.R.layout.fragment_perfil_terceiro);
      sKeys.put("layout/fragment_pergunta_0", com.example.projetointegrador.R.layout.fragment_pergunta);
      sKeys.put("layout/fragment_ranking_0", com.example.projetointegrador.R.layout.fragment_ranking);
      sKeys.put("layout/fragment_resultado_0", com.example.projetointegrador.R.layout.fragment_resultado);
      sKeys.put("layout/fragment_sobrevivencia_0", com.example.projetointegrador.R.layout.fragment_sobrevivencia);
      sKeys.put("layout/progressbar_layout_0", com.example.projetointegrador.R.layout.progressbar_layout);
    }
  }
}
