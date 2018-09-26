package com.ggx.myapplication.executor.module.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/9/6.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
/*模拟接口：
 {
      responseCode:200,
      responseText:成功,
      time:123,
      data:真正需要用到的返回Module
 }
 */
public class ResponseData<T extends Object> {
    Integer responseCode;
    String responseText;
    Long time;
    T data;
}
