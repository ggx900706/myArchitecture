package com.ggx.myarchetecture.app;

import android.support.multidex.MultiDexApplication;

import com.data.net.Client;
import com.data.repository.BusinessContructor;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by ggx
 */

public class Application extends MultiDexApplication {
    public static BusinessContructor businessContructor;

    private String imageCachePath;

    @Override
    public void onCreate() {
        super.onCreate();
        businessContructor = new BusinessContructor(new Client(new Client.ClientConfig()));
    }

    public static void changeURL(String url) {
        if (businessContructor != null)
            businessContructor.changeURL(url);
        else
            businessContructor = new BusinessContructor(new Client(new Client.ClientConfig(url)));
    }

    private void initImage() {
        ImagePipelineConfig.Builder imagePipelineConfigBuilder = ImagePipelineConfig.newBuilder(this);
        imagePipelineConfigBuilder.setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPath(getExternalCacheDir())//设置磁盘缓存的路径
                .setBaseDirectoryName("image")//设置磁盘缓存文件夹的名称
                .build());
        Fresco.initialize(this, imagePipelineConfigBuilder.build());
    }
}
