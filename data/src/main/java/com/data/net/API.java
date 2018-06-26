package com.data.net;

import com.data.entity.response.ResponseTimeEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
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
    Observable<String> commonGet(@Url String url, @QueryMap Map queryMap);
}
