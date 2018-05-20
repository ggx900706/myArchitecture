package com.ggx.myapplication.executor.entity.response.film.simple;

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
public class SimpleFilmModule {
    Rating rating;
    List<String> genres;
    String title;
    List<Person> casts;
    int collect_count;
    String original_title;
    String subtype;
    List<Person> directors;
    String year;
    Image images;
    String alt;
    String id;
}
