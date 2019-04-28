package com.ggx.myarchetecture.observable.realm;

import com.ggx.myarchetecture.interfaces.main.IDogInterface;
import com.ggx.myarchetecture.module.reaml.Dog;
import com.ggx.myarchetecture.observable.BaseObservable;

import java.util.List;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public class QueryDogObservable extends BaseObservable<List<Dog>,IDogInterface> {
    public QueryDogObservable(IDogInterface iView) {
        super(iView);
    }

    @Override
    public void onComplete() {
        super.onComplete();
        iView.queryDog(result);
    }
}
