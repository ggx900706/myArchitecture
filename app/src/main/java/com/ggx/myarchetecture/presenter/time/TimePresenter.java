package com.ggx.myarchetecture.presenter.time;

import android.arch.lifecycle.LifecycleOwner;

import com.data.usecase.time.GetCommonUsecase;
import com.data.usecase.time.GetTimeUsecase;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.module.observer.GetCommonObservable;
import com.ggx.myarchetecture.module.viewmodule.TimeModule;
import com.ggx.myarchetecture.module.observer.TimeObservable;
import com.ggx.myarchetecture.base.presenter.BasePresenter;

import java.util.Map;

/**
 * Created by ggx
 */

public class TimePresenter extends BasePresenter {
    GetTimeUsecase getTimeUsecase;
    GetCommonUsecase getCommonUsecase;

    public TimePresenter() {
        getTimeUsecase = new GetTimeUsecase(Application.businessContructor);
        getCommonUsecase = new GetCommonUsecase(Application.businessContructor);
    }

    public void getTime(TimeModule timeModule) {
        getTimeUsecase.execute(new TimeObservable(timeModule), null);
    }

    public void getCommonTest(String url, Map param) {
        getCommonUsecase.execute(new GetCommonObservable(), new GetCommonUsecase.GetCommonParam(url, param));
    }

    /*
    * dataBinding的函数，onStop，暂时不知道怎么用，就给他暂时用来进行usecase的dispose
    * */
    @Override
    public void onStop(LifecycleOwner owner) {
        dispose(getTimeUsecase);
    }
}
