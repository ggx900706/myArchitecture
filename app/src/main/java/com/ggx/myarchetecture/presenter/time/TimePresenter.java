package com.ggx.myarchetecture.presenter.time;

import android.arch.lifecycle.LifecycleOwner;
import android.util.Log;

import com.data.usecase.CommonGetUsecase;
import com.data.usecase.CommonPostUsecase;
import com.ggx.myapplication.executor.module.repository.DefaultObserver;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.data.usecase.time.GetTimeUsecase;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.interfaces.main.IMainView;
import com.ggx.myarchetecture.module.reaml.Dog;
import com.ggx.myarchetecture.observable.common.CommonObservable;
import com.ggx.myarchetecture.observable.common.ICommonHttpInterface;
import com.ggx.myarchetecture.observable.realm.AddDogObservable;
import com.ggx.myarchetecture.presenter.base.BasePresenter;
import com.ggx.myarchetecture.usecase.AddDogUseCase;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

/**
 * Created by ggx
 */

public class TimePresenter extends BasePresenter<IMainView> {
    GetTimeUsecase getTimeUsecase;
    CommonGetUsecase commonGetUsecase;
    CommonPostUsecase commonPostUsecase;

    @Setter
    ICommonHttpInterface iCommonHttpInterface;

    public TimePresenter() {
        getTimeUsecase = new GetTimeUsecase(Application.businessContructor);
        commonGetUsecase = new CommonGetUsecase(Application.businessContructor);
        commonPostUsecase = new CommonPostUsecase(Application.businessContructor);
    }

    public void getTime() {
        //正经的流程
        //getTimeUsecase.execute(new TimeObservable(), null);

        //通用get接口，参数为url和param类，param是query参数键值对，返回值为String，需要iCommonHttpInterface进行处理
        Map<String, String> param = new HashMap<>();
        param.put("api", "mtop.common.getTimestamp");
        commonGetUsecase.execute(new CommonObservable(iCommonHttpInterface), new CommonGetUsecase.GetCommonParam("http://api.m.taobao.com/rest/api3.do", param));

        //通用Post接口，参数为url和jsonObject实体类，返回值为String，需要iCommonHttpInterface进行处理
        JsonObject jsonObject = new JsonObject();
        JsonObject type = new JsonObject();
        type.addProperty("type", "app");
        jsonObject.add("data", type);
        commonPostUsecase.execute(new CommonObservable(new ICommonHttpInterface() {
        }), new CommonPostUsecase.CommonPostParam("http://47.93.242.117:8098/art-app/area/phoneCode", jsonObject));
    }

    public void saveDog(Dog dog){
        AddDogUseCase addDogUseCase = new AddDogUseCase(Application.businessContructor);
        addDogUseCase.execute(new AddDogObservable(iView),dog);
    }

    public void queryDogs(){

    }

    private class TimeObservable extends DefaultObserver<ResponseTimeModule,ICommonHttpInterface> {
        ResponseTimeModule module;

        public TimeObservable(ICommonHttpInterface iView) {
            super(iView);
        }

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
