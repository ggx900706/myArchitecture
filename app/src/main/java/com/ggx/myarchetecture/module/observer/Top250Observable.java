package com.ggx.myarchetecture.module.observer;

import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;
import com.ggx.myapplication.executor.repository.DefaultObserver;
import com.ggx.myarchetecture.module.mapper.FilmListMapper;
import com.ggx.myarchetecture.module.viewmodule.film.FilmListModule;

/**
 * Created by ggx
 */

public class Top250Observable extends DefaultObserver<ResponseFilmListModule> {

    FilmListModule filmListModule;

    @Override
    public void onComplete() {
        super.onComplete();
    }

    @Override
    public void onNext(ResponseFilmListModule responseFilmListModule) {
        this.filmListModule = FilmListMapper.transform(responseFilmListModule);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
    }
}
