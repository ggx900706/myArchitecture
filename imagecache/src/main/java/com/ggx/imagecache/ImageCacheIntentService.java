package com.ggx.imagecache;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

import java.util.List;

/**
 * Created by ggx on 2018/6/11.
 */

public class ImageCacheIntentService extends IntentService {
    public ImageCacheIntentService() {
        super("image cache service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        List<String> urlList = intent.getStringArrayListExtra("list");
        for (String str : urlList)
            fetch(str);
    }

    private void fetch(String url) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource dataSource = imagePipeline.prefetchToDiskCache(ImageRequest.fromUri(url), getApplicationContext());
        dataSource.subscribe(new CustomerBitmapDataSubscriber(), CallerThreadExecutor.getInstance());
    }

    public class CustomerBitmapDataSubscriber extends BaseBitmapDataSubscriber {

        @Override
        protected void onNewResultImpl(Bitmap bitmap) {
        }

        @Override
        protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }
    }
}
