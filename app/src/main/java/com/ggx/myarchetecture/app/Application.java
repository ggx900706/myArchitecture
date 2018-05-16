package com.ggx.myarchetecture.app;

import android.support.multidex.MultiDexApplication;

import com.data.net.Client;
import com.data.repository.BusinessContructor;

/**
 * Created by ggx
 */

public class Application extends MultiDexApplication {
    public static BusinessContructor businessContructor;

    @Override
    public void onCreate() {
        super.onCreate();
        businessContructor = new BusinessContructor(new Client(new Client.ClientConfig()));
    }
}