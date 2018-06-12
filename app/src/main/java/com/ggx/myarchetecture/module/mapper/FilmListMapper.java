package com.ggx.myarchetecture.module.mapper;

import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;
import com.ggx.myarchetecture.module.viewmodule.film.FilmListModule;
import com.ggx.myarchetecture.module.viewmodule.film.simple.SimpleFilmModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 2018/5/31.
 */

public class FilmListMapper {
    public static FilmListModule transform(ResponseFilmListModule response) {
        FilmListModule module = new FilmListModule();
        module.setCount(response.getCount());
        module.setStart(response.getStart());
        module.setTitle(response.getTitle());
        module.setCount(response.getCount());
        module.setSubjects(response.getSubjects());
        return module;
    }
}
