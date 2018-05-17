package com.ggx.myarchetecture.presenter.time;

import android.arch.lifecycle.LifecycleOwner;

import com.data.usecase.time.GetTimeUsecase;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.module.viewmodule.TimeModule;
import com.ggx.myarchetecture.module.observer.TimeObservable;
import com.ggx.myarchetecture.base.presenter.BasePresenter;

/**
 * Created by ggx
 */

public class TimePresenter extends BasePresenter {
    GetTimeUsecase getTimeUsecase;

    public TimePresenter() {
        getTimeUsecase = new GetTimeUsecase(Application.businessContructor);
    }

    public void getTime(TimeModule timeModule) {
        getTimeUsecase.execute(new TimeObservable(timeModule), null);
    }

    @Override
    public void onStop(LifecycleOwner owner) {
        dispose(getTimeUsecase);
    }
}
