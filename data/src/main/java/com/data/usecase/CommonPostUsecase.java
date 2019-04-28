package com.data.usecase;

import com.data.repository.BusinessContructor;
import com.google.gson.JsonObject;

import java.util.Map;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/6/21.
 */

public class CommonPostUsecase extends UseCase<JsonObject, CommonPostUsecase.CommonPostParam> {

    public CommonPostUsecase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<JsonObject> buildUseCaseObservable(CommonPostParam getCommonParam) {
        return repository.commonPost(getCommonParam.url, getCommonParam.param);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CommonPostParam {
        String url;
        JsonObject param;
    }
}
