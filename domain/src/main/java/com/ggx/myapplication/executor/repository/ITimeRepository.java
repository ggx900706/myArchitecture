package com.ggx.myapplication.executor.repository;

import com.ggx.myapplication.executor.module.response.ResponseTimeModule;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by ggx on 2018/5/15.
 */

public interface ITimeRepository {
    Observable<ResponseTimeModule> getSysTime(String str);

    Observable<String> getCommon(String string, Map param);
}
