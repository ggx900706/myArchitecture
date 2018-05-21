package com.ggx.myarchetecture.module.observer;

import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;
import com.ggx.myapplication.executor.repository.DefaultObserver;

/**
 * Created by ggx
 */

public class Top250Observable extends DefaultObserver<ResponseFilmListModule> {

    @Override
    public void onComplete() {
        super.onComplete();
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
    }
}
