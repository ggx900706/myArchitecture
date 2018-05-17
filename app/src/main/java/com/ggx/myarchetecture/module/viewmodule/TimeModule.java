package com.ggx.myarchetecture.module.viewmodule;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ggx.myarchetecture.BR;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by ggx
 * viewModule
 */

@AllArgsConstructor
@NoArgsConstructor
public class TimeModule extends BaseObservable {
    public String api;
    public String v;
    public String data = "init data";

    @Bindable
    public String getApi() {
        return api;
    }

    @Bindable
    public String getV() {
        return v;
    }

    @Bindable
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        //这里只显示这一个值，所以通知刷新页面刷新这一个值
        notifyPropertyChanged(BR.data);
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setV(String v) {
        this.v = v;
    }
}
