package com.aravindraj.demo001;

import android.app.Application;

import com.aravindraj.demo001.db.DbOpenHelper;

/**
 * Created by Aravindraj on 11/21/2017.
 */
public class DemoApp extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DbOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}