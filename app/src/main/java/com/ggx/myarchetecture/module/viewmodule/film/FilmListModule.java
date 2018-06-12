package com.ggx.myarchetecture.module.viewmodule.film;

import com.ggx.myapplication.executor.entity.response.film.simple.SimpleFilmModule;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/5/19.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmListModule {
    Integer count;
    Integer start;
    Integer total;
    List<SimpleFilmModule> subjects;
    String title;
}
