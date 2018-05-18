package com.data.net;

import com.data.entity.response.ResponseMovie250ListEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ggx
 */

public interface DoubanAPI {
    @GET("movie/top250")
    Observable<ResponseMovie250ListEntity> getSysTime();
}
