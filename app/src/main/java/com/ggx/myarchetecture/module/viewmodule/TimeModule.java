package com.ggx.myarchetecture.module.viewmodule;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.data.usecase.time.GetTimeUsecase;
import com.ggx.myarchetecture.BR;
import com.ggx.myarchetecture.app.Application;
import com.ggx.myarchetecture.base.view.BaseViewModel;
import com.ggx.myarchetecture.module.observer.TimeObservable;

/**
 * Created by ggx
 * viewModule
 */

public class TimeModule extends BaseViewModel {
    public String api;
    public String v;
    public String data = "init data";

    //这里只有少数接口和少数的参数，可以直接使用viewModule
    //接口或者参数数量大，建议使用presenter
    // 如果使用，需要让Presenter继承自LifecycleObserver并且在onDestory中调用相应Usecase的dispose去保证usecase的安全退出
    GetTimeUsecase getTimeUsecase;

    public TimeModule(Context context) {
        super(context);
    }

    /**
     * databinding的数据处理
     */
    @Bindable
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        //这里只显示这一个值，所以通知刷新页面刷新这一个值
        notifyPropertyChanged(BR.data);
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setV(String v) {
        this.v = v;
    }

    /**
     * lifecycle的生命周期
     */
    @Override
    public void onCreate(LifecycleOwner owner) {
        getTimeUsecase = new GetTimeUsecase(Application.businessContructor);
    }

    @Override
    public void onStop(LifecycleOwner owner) {
        dispose(getTimeUsecase);
    }

    /**
     * databinding的按钮点击事件
     */
    public void getTime(View view) {
        getTimeUsecase.execute(new TimeObservable(this), null);
    }

    public void clear(View view) {
        this.setData("clear screen");
    }
}
