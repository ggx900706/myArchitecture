package com.data.repository;

<<<<<<< HEAD
import com.ggx.myapplication.executor.mapper.TimeMapper;
import com.ggx.myapplication.executor.mapper.film.Top250Mapper;
import com.data.net.Client;
import com.ggx.myapplication.executor.repository.IDoubanRepository;
import com.ggx.myapplication.executor.repository.ITimeRepository;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;
=======
import com.data.mapper.TimeMapper;
import com.data.net.CheckSuccess;
import com.data.net.Client;
import com.ggx.myapplication.executor.module.response.ResponseData;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.google.gson.JsonObject;
>>>>>>> master

import java.util.Map;

import io.reactivex.Observable;

import static com.data.usecase.film.GetTop250FilmListUseCase.Comming;
import static com.data.usecase.film.GetTop250FilmListUseCase.In_Theaters;
import static com.data.usecase.film.GetTop250FilmListUseCase.Top_250;

/**
 * Created by ggx on 2018/5/15.
 */

public class Repository implements IDoubanRepository, ITimeRepository {

    Client client;

    Repository(Client client) {
        this.client = client;
    }

    @Override
    public Observable<ResponseTimeModule> getSysTime(String str) {
        return client.getAPI().getSysTime(str).map(TimeMapper::transform);
    }

<<<<<<< HEAD
    @Override
    public Observable<String> getCommon(String string, Map param) {
        return client.getAPI().commonGet(string,param);
    }

    @Override
    public Observable<ResponseFilmListModule> getTop250(int index, int start, int count) {
        switch (index) {
            case Top_250:
                return client.getAPI().getTop250(start, count).map(Top250Mapper::transformFilmList);
            case Comming:
                return client.getAPI().getInTheaters(start, count).map(Top250Mapper::transformFilmList);
            case In_Theaters:
            default:
                return client.getAPI().getInTheaters(start, count).map(Top250Mapper::transformFilmList);
        }
=======
    public Observable<JsonObject> commonGet(String string, Map<String, String> param) {
        return client.getAPI().commonGet(string, param);
    }

    public Observable<JsonObject> commonPost(String url, JsonObject param) {
        return client.getAPI().commonPost(url, param);
    }


    public Observable<ResponseData<String>> tempAPI() {
        return client.getAPI().tempAPI().map(CheckSuccess::checkSuccess);
>>>>>>> master
    }
}
