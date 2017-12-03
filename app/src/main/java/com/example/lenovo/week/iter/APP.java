package com.example.lenovo.week.iter;

import android.app.Application;

import com.afa.tourism.greendao.gen.DaoMaster;
import com.afa.tourism.greendao.gen.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.greendao.database.Database;

/**
 * Created by lenovo on 2017/12/2.
 */

public class APP extends Application {

    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "thest");
        Database database = devOpenHelper.getWritableDb();
        session = new DaoMaster(database).newSession();
    }
}
