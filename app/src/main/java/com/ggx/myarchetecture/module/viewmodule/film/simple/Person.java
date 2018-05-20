package com.ggx.myarchetecture.module.viewmodule.film.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/5/19.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String alt;
    String name;
    String id;
    Image avatars;
}
