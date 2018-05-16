package com.ggx.myarchetecture.presenter.time;

import com.ggx.myapplication.executor.module.repository.DefaultObserver;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.data.usecase.time.GetTimeUsecase;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.presenter.BasePresenter;

/**
 * Created by ggx
 */

public class TimePresenter extends BasePresenter<TimePresenter.IMainActivityInterface> {

    public TimePresenter() {
    }

    public void getTime() {
        GetTimeUsecase getTimeUsecase = new GetTimeUsecase(Application.businessContructor);
        getTimeUsecase.execute(new TimeObservable(), null);
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
}
