package com.ggx.myarchetecture.module.observer;

import com.ggx.myapplication.executor.module.repository.DefaultObserver;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.ggx.myarchetecture.module.viewmodule.TimeModule;
import com.ggx.myarchetecture.module.mapper.TimeMapper;

/**
 * Created by ggx
 */

//T 是返回类型，data层返回实体转化为domain层的返回module
public class TimeObservable extends DefaultObserver<ResponseTimeModule> {
    ResponseTimeModule module;
    TimeModule timeModule;

    public TimeObservable(TimeModule response) {
        this.timeModule = response;
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

        //这里使用了dataBinding，把返回值转换成viewModule
        TimeMapper.transform(module, timeModule);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        throwable.printStackTrace();
    }
}
