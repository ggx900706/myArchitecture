package com.ggx.myapplication.executor.mapper;

import com.ggx.myapplication.executor.entity.response.ResponseTimeEntity;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;

/**
 * Created by ggx on 2018/5/15.
 */

public class TimeMapper {
    public static ResponseTimeModule transform(ResponseTimeEntity responseTimeEntity) {
        ResponseTimeModule responseTimeModule = new ResponseTimeModule();
        responseTimeModule.setApi(responseTimeEntity.getApi());
        responseTimeModule.setV(responseTimeEntity.getV());
        responseTimeModule.setData(responseTimeEntity.getData().getT());
        return responseTimeModule;
    }
}
