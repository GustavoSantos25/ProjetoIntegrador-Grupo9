package com.example.projetointegrador.databinding;
import com.example.projetointegrador.R;
import com.example.projetointegrador.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.username, 2);
        sViewsWithIds.put(R.id.password, 3);
        sViewsWithIds.put(R.id.btnLogin, 4);
        sViewsWithIds.put(R.id.tvCadastre_se, 5);
        sViewsWithIds.put(R.id.grid, 6);
        sViewsWithIds.put(R.id.lbtn_Facebook, 7);
        sViewsWithIds.put(R.id.ivFacebook, 8);
        sViewsWithIds.put(R.id.ivLoginGoogle, 9);
        sViewsWithIds.put(R.id.loading, 10);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.GridLayout) bindings[6]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (com.facebook.login.widget.LoginButton) bindings[7]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.ProgressBar) bindings[10]
            , (android.widget.EditText) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.EditText) bindings[2]
            );
        this.container.setTag(null);
        this.linearLayout3.setTag(null);
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