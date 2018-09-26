package com.data.net;

import com.data.exception.TokenDisabledException;
import com.ggx.myapplication.executor.module.response.ResponseData;

/**
 * Created by ggx on 2018/9/26.
 */

public class CheckSuccess {
    //假设int值200代表接口成功
    //否则接口调用失败，具体原因写在Exception中，可以自定义
    //假设300为token失效
    //处理方式为：
    //App中的com.ggx.myarchetecture.observable.BaseObservable类中判断onError向界面输出错误。
    public static ResponseData checkSuccess(ResponseData responseData) throws Exception {
        if (responseData.getResponseCode() == 200) {
            return responseData;
        } else if (responseData.getResponseCode() == 300) {
            throw new TokenDisabledException();
        } else {
            throw new Exception(responseData.getResponseText());
        }
    }
}
