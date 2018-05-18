package com.data.net;

import com.data.entity.response.ResponseTimeEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ggx
 */

public interface TaobaoAPI {
    @GET("rest/api3.do?")
    Observable<ResponseTimeEntity> getSysTime(@Query("api") String string);
}
