package com.ggx.myarchetecture.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ggx.myarchetecture.R;
import com.ggx.myarchetecture.interfaces.main.IDogInterface;
import com.ggx.myarchetecture.interfaces.main.IMainView;
import com.ggx.myarchetecture.module.reaml.Dog;
import com.ggx.myarchetecture.observable.common.ICommonHttpInterface;
import com.ggx.myarchetecture.presenter.time.TimePresenter;
import com.ggx.myarchetecture.view.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements IMainView, ICommonHttpInterface {
    Dog dog;

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ll)
    LinearLayout ll;

    TimePresenter timePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        timePresenter = new TimePresenter();
        timePresenter.setView(this);
        timePresenter.setICommonHttpInterface(this);
        getLifecycle().addObserver(timePresenter);
        initDog();
        timePresenter.saveDog(dog);
        queryAllDog();
    }

    @Override
    public void getTimeSucces(String str) {
        tv.setText(str);
    }

    @OnClick(R.id.btn)
    public void getTime() {
        timePresenter.getTime();
    }

    @OnClick(R.id.clrBtn)
    public void clear() {
        tv.setText("clear");
    }

    @Override
    public void onSuccess(String result) {
        Log.e("------", "get result : " + result);
    }

    @Override
    public void onException(Throwable throwable) {
        throwable.printStackTrace();
        Log.e("------", "get error : " + throwable.toString());
    }

    private void initDog() {
        dog = new Dog();
        dog.setAge(3);
        dog.setName("333");
    }

    @Override
    public void addDog(boolean success) {
        Log.e("------", "add dog success");
    }

    @Override
    public void queryDog(List<Dog> dogs) {

    }

    public List<Dog> queryAllDog() {
        ll.removeAllViews();
        Realm mRealm = Realm.getDefaultInstance();
        RealmResults<Dog> dogs = mRealm.where(Dog.class).findAll();
        List<Dog> dogList = mRealm.copyFromRealm(dogs);
        for (Dog dog : dogList) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(dog.getAge() + "      " + dog.getName());
            ll.addView(textView);
        }
        return mRealm.copyFromRealm(dogs);
    }
}
