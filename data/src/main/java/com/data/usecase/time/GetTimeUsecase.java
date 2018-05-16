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

public class GetTimeUsecase extends UseCase<ResponseTimeModule, Void> {
    public GetTimeUsecase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<ResponseTimeModule> buildUseCaseObservable(Void aVoid) {
        return repository.getSysTime("mtop.common.getTimestamp");
    }
}
