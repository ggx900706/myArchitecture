package com.ggx.myarchetecture.observable.common;

import com.ggx.myapplication.executor.module.repository.DefaultObserver;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;

/**
 * Created by ggx on 2018/6/21.
 */

public class GetCommonObservable extends DefaultObserver<JsonObject> {
    String result;
    ICommonHttpInterface iCommonHttpInterface;

    public GetCommonObservable(ICommonHttpInterface iCommonHttpInterface) {
        this.iCommonHttpInterface = iCommonHttpInterface;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(JsonObject s) {
        super.onNext(s);
        result = s.toString();
    }

    @Override
    public void onComplete() {
        super.onComplete();
        iCommonHttpInterface.onSuccess(result);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        iCommonHttpInterface.onFailed(throwable.getMessage());
    }
}
