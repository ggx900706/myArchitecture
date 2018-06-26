package com.ggx.myarchetecture.observable;

import com.ggx.myapplication.executor.module.repository.DefaultObserver;

/**
 * Created by ggx on 2018/6/21.
 */

public class GetCommonObservable extends DefaultObserver<String> {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(String s) {
        super.onNext(s);
    }

    @Override
    public void onComplete() {
        super.onComplete();
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
    }
}
