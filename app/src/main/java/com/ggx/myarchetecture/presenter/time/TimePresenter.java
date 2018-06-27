package com.ggx.myarchetecture.presenter.time;

import android.arch.lifecycle.LifecycleOwner;

import com.data.usecase.GetCommonUsecase;
import com.ggx.myapplication.executor.module.repository.DefaultObserver;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.data.usecase.time.GetTimeUsecase;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.observable.common.GetCommonObservable;
import com.ggx.myarchetecture.observable.common.ICommonHttpInterface;
import com.ggx.myarchetecture.presenter.base.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import lombok.Setter;

/**
 * Created by ggx
 */

public class TimePresenter extends BasePresenter<TimePresenter.IMainActivityInterface> {
    GetTimeUsecase getTimeUsecase;
    GetCommonUsecase getCommonUsecase;

    @Setter
    ICommonHttpInterface iCommonHttpInterface;

    public TimePresenter() {
        getTimeUsecase = new GetTimeUsecase(Application.businessContructor);
        getCommonUsecase = new GetCommonUsecase(Application.businessContructor);
    }

    public void getTime() {
//        getTimeUsecase.execute(new TimeObservable(), null);
        Map<String, String> param = new HashMap<>();
        param.put("api", "mtop.common.getTimestamp");
        getCommonUsecase.execute(new GetCommonObservable(iCommonHttpInterface), new GetCommonUsecase.GetCommonParam("http://api.m.taobao.com/rest/api3.do", param));
    }

    private class TimeObservable extends DefaultObserver<ResponseTimeModule> {
        ResponseTimeModule module;

        @Override
        protected void onStart() {
            super.onStart();
        }

        @Override
        public void onNext(ResponseTimeModule responseTimeModule) {
            super.onNext(responseTimeModule);
            this.module = responseTimeModule;
        }

        @Override
        public void onComplete() {
            super.onComplete();
            iView.getTimeSucces(module.toString() + "   \n   " + module.getData());
        }

        @Override
        public void onError(Throwable throwable) {
            super.onError(throwable);
            throwable.printStackTrace();
            iView.getTimeSucces("error --- " + throwable.toString());
        }
    }

    public interface IMainActivityInterface {
        void getTimeSucces(String timeLong);
    }

    @Override
    public void onResume(LifecycleOwner owner) {

    }

    @Override
    public void onPause(LifecycleOwner owner) {

    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }
}
