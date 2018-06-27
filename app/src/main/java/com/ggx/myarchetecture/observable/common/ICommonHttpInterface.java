package com.ggx.myarchetecture.observable.common;

/**
 * Created by ggx on 2018/6/27.
 */

public interface ICommonHttpInterface{
    void onSuccess(String result);

    void onFailed(String errorMessage);
}
