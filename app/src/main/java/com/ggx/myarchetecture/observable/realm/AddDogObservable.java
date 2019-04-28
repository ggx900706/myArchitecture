package com.ggx.myarchetecture.observable.realm;

import com.ggx.myarchetecture.interfaces.main.IDogInterface;
import com.ggx.myarchetecture.module.reaml.Dog;
import com.ggx.myarchetecture.observable.BaseObservable;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public class AddDogObservable<Void> extends BaseObservable<Dog,IDogInterface> {
    public AddDogObservable(IDogInterface iView) {
        super(iView);
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        super.onComplete();
        iView.addDog(true);
    }
}
