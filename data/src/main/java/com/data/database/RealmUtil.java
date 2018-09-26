package example.ggx.com.realmdemo;

import android.content.Context;
import android.content.Entity;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by ggx on 2018/8/17.
 */

public class RealmUtil {
    private static Realm sRealm;

    public static void init() {
        sRealm = Realm.getDefaultInstance();
    }

    public static <T extends RealmObject> void save(final List<T> realmObj) {
        sRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(realmObj);
            }
        });
    }

    public static <T extends RealmObject> void save(final T realmObj) {
        sRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(realmObj);
            }
        });
    }

    public static <T extends RealmObject> RealmResults<T> findAll(Class<T> clazz) {
        RealmResults<T> realmList = sRealm.where(clazz).findAll();
        return realmList;
    }

    public static <T extends RealmObject> RealmResults<T> findAllWhere(Class<T> clazz, String whereK, String whereV) {
        RealmResults<T> realmList = sRealm.where(clazz)
                .equalTo(whereK, whereV)
                .findAll();
        return realmList;
    }

    public static <T extends RealmObject> RealmResults<T> findAllWhere(Class<T> clazz, HashMap<String, String> where) {
        Set<Map.Entry<String, String>> entrySet = where.entrySet();
        RealmQuery<T> tempRealm = sRealm.where(clazz);
        for (Map.Entry<String, String> entry : entrySet) {
            tempRealm.equalTo(entry.getKey(), entry.getValue());
        }
        RealmResults<T> realmList = tempRealm.findAll();
        return realmList;
    }

    public static <T extends RealmObject> void delete(final T realmObj) {
        sRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Log.e("------", "delete");
                realmObj.deleteFromRealm();
            }
        });
    }

}
