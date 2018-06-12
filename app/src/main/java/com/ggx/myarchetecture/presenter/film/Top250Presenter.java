package com.ggx.myarchetecture.presenter.film;

import android.arch.lifecycle.LifecycleOwner;

import com.data.usecase.film.GetTop250FilmListUseCase;
import com.ggx.myarchetecture.base.presenter.BasePresenter;
import com.ggx.myarchetecture.module.observer.Top250Observable;
import com.ggx.myarchetecture.module.viewmodule.film.FilmListModule;

/**
 * Created by ggx
 */

public class Top250Presenter extends BasePresenter<FilmListModule> {
    GetTop250FilmListUseCase useCase;
    int index;

    public Top250Presenter(int index) {
        this.index = index;
    }

    public void getFilmList(@GetTop250FilmListUseCase.GetTop250FilmList int index) {
        useCase.execute(new Top250Observable(), new GetTop250FilmListUseCase.Params(index, 0, 20));
    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }
}
