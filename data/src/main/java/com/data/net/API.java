package com.data.net;

import com.ggx.myapplication.executor.entity.response.ResponseTimeEntity;
import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ggx on 2018/5/15.
 */

public interface API{
    //taobao api
    @GET("rest/api3.do?")
    Observable<ResponseTimeEntity> getSysTime(@Query("api") String string);

    //douban api
    @GET("movie/in_theaters")
    Observable<ResponseFilmListEntity> getInTheaters(int start, int count);

    @GET("movie/top250")
    Observable<ResponseFilmListEntity> getTop250(int start, int count);

    @GET("movie/coming_soon")
    Observable<ResponseFilmListEntity> getComming(int start, int count);
}
