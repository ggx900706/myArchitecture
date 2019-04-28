package com.ggx.myapplication.executor.module.repository;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public abstract class RealmObserver<T,I> extends DisposableObserver<T> {

}
