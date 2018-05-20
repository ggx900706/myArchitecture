package com.ggx.myarchetecture.base.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.databinding.BaseObservable;
import android.support.v7.app.AlertDialog;

import com.data.usecase.UseCase;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseViewModel extends BaseObservable implements LifecycleObserver {
    public Context context;
    AlertDialog alertDialog;

    public BaseViewModel(Context context) {
        this.context = context;
        alertDialog = new AlertDialog.Builder(context).create();
    }

    public void showDialog() {
    }

    public void hideDialog() {
    }

    protected void dispose(UseCase useCase) {
        if (useCase != null)
            useCase.dispose();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public abstract void onCreate(LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public abstract void onStop(LifecycleOwner owner);
}
