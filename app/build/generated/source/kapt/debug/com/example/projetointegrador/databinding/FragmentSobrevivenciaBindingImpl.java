package com.example.projetointegrador.databinding;
import com.example.projetointegrador.R;
import com.example.projetointegrador.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSobrevivenciaBindingImpl extends FragmentSobrevivenciaBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.includeToolbarQuizSobrevivencia, 1);
        sViewsWithIds.put(R.id.constraintLayout, 2);
        sViewsWithIds.put(R.id.view, 3);
        sViewsWithIds.put(R.id.frameLayout, 4);
        sViewsWithIds.put(R.id.tvPerguntaSobrevivencia, 5);
        sViewsWithIds.put(R.id.civPontosSobrevivencia, 6);
        sViewsWithIds.put(R.id.tvQtdeAcertos, 7);
        sViewsWithIds.put(R.id.tvAcertosString, 8);
        sViewsWithIds.put(R.id.civPerguntas, 9);
        sViewsWithIds.put(R.id.tvRecorde, 10);
        sViewsWithIds.put(R.id.tvRecordeString, 11);
        sViewsWithIds.put(R.id.btnPrimeiraRespostaSobrevivencia, 12);
        sViewsWithIds.put(R.id.btnSegundaRespostaSobrevivencia, 13);
        sViewsWithIds.put(R.id.btnTerceiraRespostaSobrevivencia, 14);
        sViewsWithIds.put(R.id.btnQuartaRespostaSobrevivencia, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSobrevivenciaBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private FragmentSobrevivenciaBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[12]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[13]
            , (androidx.appcompat.widget.AppCompatButton) bindings[14]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[9]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.FrameLayout) bindings[4]
            , (android.view.View) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
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