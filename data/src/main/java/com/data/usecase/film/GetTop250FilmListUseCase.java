package com.data.usecase.film;

import android.support.annotation.IntDef;

import com.data.repository.BusinessContructor;
import com.data.usecase.UseCase;
import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ggx on 2018/5/19.
 */

public class GetTop250FilmListUseCase extends UseCase<ResponseFilmListModule, GetTop250FilmListUseCase.Params> {

    public static final int Top_250 = 0;
    public static final int Comming = 1;
    public static final int In_Theaters = 2;

    @IntDef({Top_250,Comming,In_Theaters})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GetTop250FilmList{};

    public GetTop250FilmListUseCase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    protected Observable<ResponseFilmListModule> buildUseCaseObservable(Params params) {
        return repository.getTop250(params.index, params.start, params.count);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Params {
        @GetTop250FilmList int index = In_Theaters;
        int start = 0;
        int count = 20;
    }
}
