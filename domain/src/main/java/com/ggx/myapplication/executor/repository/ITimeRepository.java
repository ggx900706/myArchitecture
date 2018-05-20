package com.ggx.myapplication.executor.repository;

import com.ggx.myapplication.executor.module.response.ResponseTimeModule;

import io.reactivex.Observable;

/**
 * Created by ggx on 2018/5/15.
 */

public interface ITimeRepository {
    public Observable<ResponseTimeModule> getSysTime(String str);
}
