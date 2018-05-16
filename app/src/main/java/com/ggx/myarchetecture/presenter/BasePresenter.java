package com.ggx.myarchetecture.presenter;

import android.support.annotation.CallSuper;

import com.data.usecase.UseCase;

public abstract class BasePresenter<T> {

    protected T iView;

    public BasePresenter() {

    }

    public void setView(T view) {
        iView = view;
    }

    public void resume() {
    }

    public void pause() {
    }

    @CallSuper
    public void destroy() {
        iView = null;
    }

    protected T getView() {
        return iView;
    }

    protected void dispose(UseCase useCase) {
        if (useCase != null) {
            useCase.dispose();
        }
    }
}
