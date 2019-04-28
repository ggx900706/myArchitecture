package com.ggx.myarchetecture.observable.common;

import android.util.Log;

import com.ggx.myapplication.executor.module.repository.ILoadDataInterface;

/**
 * Created by ggx on 2018/6/27.
 */

public interface ICommonHttpInterface extends ILoadDataInterface{

    default void onSuccess(String result) {
        Log.e("------", "in ICommonHttpInterface , onSuccess : " + result);
    }

    default void onException(Throwable throwable) {
        Log.e("------", "in ICommonHttpInterface , onException : " + throwable.toString());
        throwable.printStackTrace();
    }
}
