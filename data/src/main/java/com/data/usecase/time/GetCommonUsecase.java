package com.data.usecase.time;

import com.data.repository.BusinessContructor;
import com.data.usecase.UseCase;

import java.util.Map;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by len on 2018/6/21.
 */

public class GetCommonUsecase extends UseCase<String, GetCommonUsecase.GetCommonParam> {

    public GetCommonUsecase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<String> buildUseCaseObservable(GetCommonParam getCommonParam) {
        return repository.getCommon(getCommonParam.url, getCommonParam.param);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetCommonParam {
        String url;
        Map param;
    }
}
