package com.data.usecase.time;

import com.data.repository.BusinessContructor;
import com.ggx.myapplication.executor.module.executor.UIThread;
import com.ggx.myapplication.executor.module.response.ResponseTimeModule;
import com.data.usecase.UseCase;

import java.util.concurrent.Executor;

import io.reactivex.Observable;

/**
 * Created by ggx
 */

/*
* 第一个泛型是返回值，通常为domain里面的module，第二个泛型为参数
* 这里就是干净架构的mvp流程，没有不同
* */
public class GetTimeUsecase extends UseCase<ResponseTimeModule, Void> {
    public GetTimeUsecase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<ResponseTimeModule> buildUseCaseObservable(Void aVoid) {
        return repository.getSysTime("mtop.common.getTimestamp");
    }
}
