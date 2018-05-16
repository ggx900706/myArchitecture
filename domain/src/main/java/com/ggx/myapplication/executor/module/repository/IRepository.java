package com.ggx.myapplication.executor.module.repository;

import com.ggx.myapplication.executor.module.response.ResponseTimeModule;

import io.reactivex.Observable;

/**
 * Created by ggx on 2018/5/15.
 */

public interface IRepository {
    public Observable<ResponseTimeModule> getSysTime();
}
