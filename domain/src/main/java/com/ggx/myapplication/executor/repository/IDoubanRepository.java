package com.ggx.myapplication.executor.repository;

import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;

import io.reactivex.Observable;

/**
 * Created by ggx on 2018/5/15.
 */

public interface IDoubanRepository {
    public Observable<ResponseFilmListModule> getTop250(int index, int start, int count);
}
