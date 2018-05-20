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
public class SimpleFilmEntity {
    RatingEntity rating;
    List<String> genres;
    String title;
    List<PersonEntity> casts;
    Integer collect_count;
    String original_title;
    String subtype;
    List<PersonEntity> directors;
    String year;
    ImageEntity images;
    String alt;
    String id;
}
