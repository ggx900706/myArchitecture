package com.ggx.myapplication.executor.entity.response.film;

import com.ggx.myapplication.executor.entity.response.film.simple.SimpleFilmEntity;

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
public class ResponseFilmListEntity {
    Integer count;
    Integer start;
    Integer total;
    List<SimpleFilmEntity> subjects;
    String title;
}
