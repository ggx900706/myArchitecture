package com.ggx.myarchetecture.observable;

import com.data.exception.TokenDisabledException;
import com.ggx.myapplication.executor.module.repository.DefaultObserver;
import com.ggx.myapplication.executor.module.repository.ILoadDataInterface;

/**
 * Created by ggx on 2018/9/26.
 */

public class BaseObservable<T, I extends ILoadDataInterface> extends DefaultObserver<T, I> {
    public BaseObservable(I iView) {
        super(iView);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        if (throwable instanceof TokenDisabledException) {

        }
    }
}
