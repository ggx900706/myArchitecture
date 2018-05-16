package com.data.mapper;

import android.util.Log;

import com.data.entity.response.ResponseTimeEntity;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.google.gson.Gson;

/**
 * Created by ggx on 2018/5/15.
 */

public class TimeMapper {
    public static ResponseTimeModule transform(ResponseTimeEntity responseTimeEntity) {

        Log.e("------",new Gson().toJson(responseTimeEntity));

        ResponseTimeModule responseTimeModule = new ResponseTimeModule();
        responseTimeModule.setApi(responseTimeEntity.getApi());
        responseTimeModule.setV(responseTimeEntity.getV());
        responseTimeModule.setData(responseTimeEntity.getData().getT());
        return responseTimeModule;
    }
}
