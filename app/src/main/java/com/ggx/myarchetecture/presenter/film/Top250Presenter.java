package com.ggx.myarchetecture.presenter.film;

import android.arch.lifecycle.LifecycleOwner;

import com.data.usecase.film.GetTop250FilmListUseCase;
import com.ggx.myarchetecture.base.presenter.BasePresenter;
import com.ggx.myarchetecture.module.viewmodule.film.FilmListModule;

/**
 * Created by ggx
 */

public class Top250Presenter extends BasePresenter<FilmListModule> {

    public Top250Presenter() {

    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }
}
