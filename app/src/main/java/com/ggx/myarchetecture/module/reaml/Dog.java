package com.ggx.myarchetecture.module.reaml;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends RealmObject{
    String name;
    int age;
}
