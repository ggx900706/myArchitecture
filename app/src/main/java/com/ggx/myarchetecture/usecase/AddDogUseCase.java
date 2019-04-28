package com.ggx.myarchetecture.usecase;

import com.data.repository.BusinessContructor;
import com.ggx.myarchetecture.module.reaml.Dog;
import com.ggx.myarchetecture.usecase.base.RealmUseCase;

import io.realm.Realm;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public class AddDogUseCase extends RealmUseCase<Void,Dog> {
    public AddDogUseCase(BusinessContructor businessContructor) {
        super(businessContructor);
    }

    @Override
    public Void realmFuncion(Realm realm, Dog dog) {
        realm.insert(dog);
        return null;
    }
}
