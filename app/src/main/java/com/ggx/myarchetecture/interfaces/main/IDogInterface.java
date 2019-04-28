package com.ggx.myarchetecture.interfaces.main;

import com.ggx.myapplication.executor.module.repository.ILoadDataInterface;
import com.ggx.myarchetecture.module.reaml.Dog;

import java.util.List;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public interface IDogInterface extends ILoadDataInterface {
    void addDog(boolean success);

    void queryDog(List<Dog> dogs);
}
