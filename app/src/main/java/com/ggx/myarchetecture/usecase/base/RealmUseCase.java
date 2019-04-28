package com.ggx.myarchetecture.usecase.base;

import com.data.repository.BusinessContructor;
import com.data.usecase.UseCase;
import com.facebook.common.internal.Preconditions;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

//T是返回结果
    //param是参数，理论上应该继承自RealmObject
public abstract class RealmUseCase<T, Param> extends UseCase<T, Param> {
    public RealmUseCase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<T> buildUseCaseObservable(Param param) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                e.onNext(realmFuncion(realm, param));
                realm.commitTransaction();
            }
        });
    }

    public void execute(DisposableObserver<T> observer, Param params) {
        Preconditions.checkNotNull(observer);

        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(uiThread.getScheduler())
                .observeOn(uiThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    public abstract T realmFuncion(Realm realm, Param param);
}
