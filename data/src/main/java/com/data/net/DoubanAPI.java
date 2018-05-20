package com.data.net;

import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ggx
 */

public interface DoubanAPI {

    @GET("movie/in_theaters")
    Observable<ResponseFilmListEntity> getInTheaters(int start, int count);

    @GET("movie/top250")
    Observable<ResponseFilmListEntity> getTop250(int start, int count);

    @GET("movie/coming_soon")
    Observable<ResponseFilmListEntity> getComming(int start, int count);
}
