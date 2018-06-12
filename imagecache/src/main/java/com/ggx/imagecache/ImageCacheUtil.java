package com.ggx.imagecache;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggx on 2018/6/11.
 */

public class ImageCacheUtil {
    private static Context context;
    private static String diskCachePath = "path";
    private static File dirPath = Environment.getExternalStorageDirectory();

    private static final int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory();
    public static final int MAX_DISK_CACHE_SIZE = 300 * ByteConstants.MB;
    public static final int MAX_MEMORY_CACHE_SIZE = MAX_HEAP_SIZE / 3;

    public static void init(Context context, String dirPath, String dirName) {
        ImageCacheUtil.context = context;
        if (diskCachePath != null && diskCachePath.length() > 0)
            ImageCacheUtil.diskCachePath = dirName;
        if (dirPath != null && dirPath.length() > 0)
            ImageCacheUtil.dirPath = new File(dirPath);
        init();
    }

    private static void init() {
        File file = new File(dirPath, diskCachePath);
        if (!file.exists())
            file.mkdirs();

        DiskCacheConfig diskCacheConfig =
                DiskCacheConfig.newBuilder(context)
                        .setBaseDirectoryPath(dirPath)
                        .setBaseDirectoryName(diskCachePath)
                        .setMaxCacheSize(MAX_DISK_CACHE_SIZE)
                        .build();

        final MemoryCacheParams bitmapCacheParams = new MemoryCacheParams(
                MAX_MEMORY_CACHE_SIZE, // Max total size of elements in the cache
                Integer.MAX_VALUE,                     // Max entries in the cache
                MAX_MEMORY_CACHE_SIZE, // Max total size of elements in eviction queue
                Integer.MAX_VALUE,                     // Max length of eviction queue
                Integer.MAX_VALUE);                    // Max cache entry size

        ImagePipelineConfig imagePipelineConfig =
                ImagePipelineConfig.newBuilder(context)
                        .setMainDiskCacheConfig(diskCacheConfig)
                        .setBitmapMemoryCacheParamsSupplier(
                                new Supplier<MemoryCacheParams>() {
                                    public MemoryCacheParams get() {
                                        return bitmapCacheParams;
                                    }
                                })
                        .build();
        Fresco.initialize(context, imagePipelineConfig);
    }

    public static void prefetchImage(ArrayList<String> urls) {
        context.startService(new Intent(context, ImageCacheIntentService.class).putStringArrayListExtra("list", urls));
    }

    public static void prefetchImage(String url) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(url);
        prefetchImage(arrayList);
    }
}
