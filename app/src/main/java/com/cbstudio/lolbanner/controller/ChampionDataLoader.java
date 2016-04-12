package com.cbstudio.lolbanner.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cbstudio.lolbanner.model.dao.ChampionData;
import com.cbstudio.lolbanner.model.dao.ChampionDataDao;
import com.cbstudio.lolbanner.model.dao.DaoMaster;
import com.cbstudio.lolbanner.model.dao.DaoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Colabear on 2016-04-12.
 */
public class ChampionDataLoader extends  {

    private static ChampionDataLoader sInstance = null;

    public static ChampionDataLoader getsInstance()
    {
        if(sInstance == null) sInstance = new ChampionDataLoader();
        return sInstance;
    }

    private  final String NAME_DB = "cbstudio_lolbanner";
    private Context context;
    private ChampionDataDao championDataDao;
    private List<ChampionData> championDataList;

    public  void init(Context context)
    {
        this.context = context;
        championDataList = new ArrayList<>();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, NAME_DB, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        championDataDao = daoSession.getChampionDataDao();
    }

    public ChampionDataDao getChampionDataDao() {
        return championDataDao;
    }
}
