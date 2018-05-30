package com.ggx.myarchetecture.base.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.databinding.BaseObservable;
import android.support.v7.app.AlertDialog;

import com.data.usecase.UseCase;
import com.ggx.myarchetecture.base.dialogs.LoadingDialog;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseViewModel extends BaseObservable implements LifecycleObserver {
    public Context context;

    public BaseViewModel(Context activity) {
        this.context = activity;
    }

    protected void dispose(UseCase useCase) {
        if (useCase != null)
            useCase.dispose();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public abstract void onCreate(LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public abstract void onStop(LifecycleOwner owner);

    LoadingDialog loadingDialog;

    public void showLoadingDialog() {
        if (loadingDialog == null)
            loadingDialog = new LoadingDialog(context);
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    public void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }
}
