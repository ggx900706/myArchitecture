package com.ggx.myarchetecture.usecase;

import com.data.repository.BusinessContructor;
import com.ggx.myarchetecture.module.reaml.Dog;
import com.ggx.myarchetecture.usecase.base.RealmUseCase;

import java.util.List;

import io.realm.Realm;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public class QueryDogUsecase extends RealmUseCase<List<Dog>,Dog> {
    public QueryDogUsecase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    public List<Dog> realmFuncion(Realm realm, Dog dog) {
        List<Dog> dogs = realm.copyFromRealm(realm.where(Dog.class).findAll());
        return dogs;
    }
}
