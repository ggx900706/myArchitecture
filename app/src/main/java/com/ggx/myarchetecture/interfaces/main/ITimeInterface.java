package com.ggx.myarchetecture.interfaces.main;

import com.ggx.myapplication.executor.module.repository.ILoadDataInterface;

/**
 * Created by gaoguanxiong on 2019/4/28.
 */

public interface ITimeInterface extends ILoadDataInterface {
    void getTimeSucces(String timeLong);
}
