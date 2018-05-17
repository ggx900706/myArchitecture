package com.ggx.myarchetecture.base.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.CallSuper;

import com.data.usecase.UseCase;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter<T> implements IBasePresenter {

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

    public void addUsecase() {

    }

    public void dispose(UseCase useCase) {
        if (useCase != null)
            useCase.dispose();
    }

    @Override
    public void onResume(LifecycleOwner owner) {

    }

    @Override
    public void onPause(LifecycleOwner owner) {

    }
}
