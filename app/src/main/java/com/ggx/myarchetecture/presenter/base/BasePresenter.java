package com.ggx.myarchetecture.presenter.base;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.CallSuper;

import com.data.usecase.UseCase;
import com.ggx.myarchetecture.presenter.base.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter<T> implements IBasePresenter{

    protected T iView;

    private List<UseCase> useCaseList;

    public BasePresenter() {
        useCaseList = new ArrayList<>();
    }

    public void setView(T view) {
        iView = view;
    }

    @CallSuper
    public void destroy() {
        iView = null;
    }

    protected T getView() {
        return iView;
    }

    public void addUsecase(){

    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }
}
