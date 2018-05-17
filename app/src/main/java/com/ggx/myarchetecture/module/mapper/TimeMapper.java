package com.ggx.myarchetecture.module.mapper;

import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.ggx.myarchetecture.module.viewmodule.TimeModule;

/**
 * Created by ggx
 */

public class TimeMapper {
    public static void transform(ResponseTimeModule responseTimeModule,TimeModule timeModule) {
        timeModule.setApi(responseTimeModule.getApi());
        timeModule.setData(responseTimeModule.getData());
        timeModule.setV(responseTimeModule.getV());
    }
}
