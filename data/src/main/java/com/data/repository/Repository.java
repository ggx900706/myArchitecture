package com.data.repository;

import com.data.mapper.TimeMapper;
import com.data.net.Client;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;

import io.reactivex.Observable;

/**
 * Created by ggx on 2018/5/15.
 */

public class Repository {

    Client client;

    Repository(Client client) {
        this.client = client;
    }

    public Observable<ResponseTimeModule> getSysTime(String str) {
        return client.getAPI().getSysTime(str).map(TimeMapper::transform);
    }
}
