package com.ggx.myapplication.executor.module.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/5/15.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTimeModule {
    String api;
    String v;
    String data;
}
