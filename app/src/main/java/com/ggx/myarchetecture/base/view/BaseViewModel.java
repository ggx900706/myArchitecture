package com.ggx.myarchetecture.base.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.databinding.BaseObservable;

public abstract class BaseViewModel extends BaseObservable implements LifecycleObserver {
    protected Context context;

    public BaseViewModel(Context context) {
        this.context = context;
    }

    public void showDialog() {
    }

    public void hideDialog() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    abstract void onResume(LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    abstract void onPause(LifecycleOwner owner);

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    abstract void onStop(LifecycleOwner owner);
}
