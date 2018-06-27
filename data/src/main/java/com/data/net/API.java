package com.data.net;

import com.data.entity.response.ResponseTimeEntity;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by ggx on 2018/5/15.
 */

public interface API {
    @GET("rest/api3.do?")
    Observable<ResponseTimeEntity> getSysTime(@Query("api") String string);

    @GET
    Observable<JsonObject> commonGet(@Url String url, @QueryMap Map<String, String> queryMap);

    @POST
    Observable<JsonObject> commonPost(@Url String url, @Body JsonObject body);
}
