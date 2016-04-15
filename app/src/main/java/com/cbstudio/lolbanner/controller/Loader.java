package com.cbstudio.lolbanner.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cbstudio.lolbanner.model.dao.DaoMaster;
import com.cbstudio.lolbanner.model.dao.DaoSession;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;

/**
 * Created by Colabear on 2016-04-15.
 */
public abstract class Loader<T> {
    protected static final String NAME_DB = "cbstudio_db_lolbanner";
    protected Context mContext;
    protected DaoSession mSession;
    protected List<T> mLoadedList;

    protected void init(Context context){
        mContext = context;
        mLoadedList = new ArrayList<T>();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext, NAME_DB, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mSession = daoMaster.newSession();
    }

    abstract AbstractDao<T,Long> getDao();
    abstract T get(long key);
    abstract List<T> getRange(int start, int count);
    abstract List<T> getAll();
    abstract  void insert(T data);
    abstract void insert(ArrayList<T> arr);
    abstract  void delete(T data);
}
