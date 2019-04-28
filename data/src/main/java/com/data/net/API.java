package com.data.net;

<<<<<<< HEAD
import com.ggx.myapplication.executor.entity.response.ResponseTimeEntity;
import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListEntity;
=======
import com.data.entity.response.ResponseTimeEntity;
import com.ggx.myapplication.executor.module.response.ResponseData;
import com.google.gson.JsonObject;

import org.json.JSONObject;
>>>>>>> master

import java.util.Map;

import io.reactivex.Observable;
import lombok.Getter;
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
    //taobao api
    @GET("rest/api3.do?")
    Observable<ResponseTimeEntity> getSysTime(@Query("api") String string);

<<<<<<< HEAD
    //douban api
    @GET("movie/in_theaters")
    Observable<ResponseFilmListEntity> getInTheaters(int start, int count);

    @GET("movie/top250")
    Observable<ResponseFilmListEntity> getTop250(int start, int count);

    @GET("movie/coming_soon")
    Observable<ResponseFilmListEntity> getComming(int start, int count);

    Observable<String> commonGet(@Url String url, @QueryMap Map queryMap);
=======
    @GET
    Observable<JsonObject> commonGet(@Url String url, @QueryMap Map<String, String> queryMap);

    @POST
    Observable<JsonObject> commonPost(@Url String url, @Body JsonObject body);

    //以下接口作为范例，假如返回值成功与否的判断
    @GET
    Observable<ResponseData<String>> tempAPI();
>>>>>>> master
}
