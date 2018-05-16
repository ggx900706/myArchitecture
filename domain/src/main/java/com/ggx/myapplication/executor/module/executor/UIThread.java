package com.ggx.myapplication.executor.module.executor;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class UIThread {
    private UIThread() {
    }

    private static final class Holder {
        private static final UIThread INSTANCE = new UIThread();
    }

    public static UIThread getInstance() {
        return Holder.INSTANCE;
    }

    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
