package com.ggx.myapplication.executor.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/5/15.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTimeEntity {
    String api;
    String v;
    Data data;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Data {
        String t;
    }
}
