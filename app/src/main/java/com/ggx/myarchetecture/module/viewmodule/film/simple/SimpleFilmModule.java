package com.ggx.myarchetecture.module.viewmodule.film.simple;


import android.arch.lifecycle.LifecycleOwner;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.ggx.myarchetecture.base.view.BaseViewModel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by ggx on 2018/5/19.
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SimpleFilmModule extends BaseViewModel {
    List<String> genres;
    public String title;
    List<Person> casts;
    public String collect_count;
    String original_title;
    String subtype;
    List<Person> directors;
    String year;
    public String imagePath;
    public String rating;
    String alt;
    String id;

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
    }

    @Override
    public void onCreate(LifecycleOwner owner) {
    }

    @Override
    public void onStop(LifecycleOwner owner) {

    }
}
