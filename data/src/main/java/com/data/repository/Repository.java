package com.data.repository;

import com.data.mapper.TimeMapper;
import com.data.net.Client;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

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

    public Observable<JsonObject> commonGet(String string, Map<String, String> param) {
        return client.getAPI().commonGet(string, param);
    }

    public Observable<JsonObject> commonPost(String url, JsonObject param) {
        return client.getAPI().commonPost(url, param);
    }
}
