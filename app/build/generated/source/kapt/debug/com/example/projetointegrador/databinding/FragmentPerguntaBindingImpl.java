package com.example.projetointegrador.databinding;
import com.example.projetointegrador.R;
import com.example.projetointegrador.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentPerguntaBindingImpl extends FragmentPerguntaBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.includeToolbarQuiz, 1);
        sViewsWithIds.put(R.id.constraintLayout, 2);
        sViewsWithIds.put(R.id.view, 3);
        sViewsWithIds.put(R.id.frameLayout, 4);
        sViewsWithIds.put(R.id.tvPergunta, 5);
        sViewsWithIds.put(R.id.civTempo, 6);
        sViewsWithIds.put(R.id.timerQuestion, 7);
        sViewsWithIds.put(R.id.civPontos, 8);
        sViewsWithIds.put(R.id.tvQtdeAcertos, 9);
        sViewsWithIds.put(R.id.tvAcertosString, 10);
        sViewsWithIds.put(R.id.civRecorde, 11);
        sViewsWithIds.put(R.id.tvRecorde, 12);
        sViewsWithIds.put(R.id.tvRecordeString, 13);
        sViewsWithIds.put(R.id.btnPrimeiraResposta, 14);
        sViewsWithIds.put(R.id.btnSegundaResposta, 15);
        sViewsWithIds.put(R.id.btnTerceiraResposta, 16);
        sViewsWithIds.put(R.id.btnQuartaResposta, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentPerguntaBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentPerguntaBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[14]
            , (androidx.appcompat.widget.AppCompatButton) bindings[17]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[16]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[8]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[11]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.FrameLayout) bindings[4]
            , (android.view.View) bindings[1]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.view.View) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}