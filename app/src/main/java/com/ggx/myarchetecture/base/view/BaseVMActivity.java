package com.ggx.myarchetecture.base.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseVMActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity {
    protected V binding;
    protected VM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewDataBinding();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initViewDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutID());
        binding.setVariable(initVariableId(), viewModel = initViewModel());
        getLifecycle().addObserver(viewModel);
    }

    public abstract int getLayoutID();

    public abstract int initVariableId();

    public abstract VM initViewModel();
}
