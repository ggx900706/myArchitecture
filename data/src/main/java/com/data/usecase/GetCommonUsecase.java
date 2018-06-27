package com.data.usecase;

import com.data.repository.BusinessContructor;
import com.data.usecase.UseCase;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/6/21.
 */

public class GetCommonUsecase extends UseCase<JsonObject, GetCommonUsecase.GetCommonParam> {

    public GetCommonUsecase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<JsonObject> buildUseCaseObservable(GetCommonParam getCommonParam) {
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
