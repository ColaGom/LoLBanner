package com.cbstudio.lolbanner.controller;

import com.cbstudio.lolbanner.model.dao.ChampionData;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;

/**
 * Created by Colabear on 2016-04-12.
 */
public class ChampionDataLoader extends Loader<ChampionData> {
    @Override
    AbstractDao<ChampionData, Long> getDao() {
        return mSession.getChampionDataDao();
    }

    @Override
    ChampionData get(long key) {
        return getDao().load(key);
    }

    @Override
    List<ChampionData> getRange(int start, int count) {
        return null;
    }

    public void replaceAll(List<ChampionData> list)
    {
        mLoadedList = list;
        getDao().deleteAll();
        getDao().insertInTx(list);
    }


    @Override
    public List<ChampionData> getAll() {
        if(mLoadedList.size() == 0 && getDao().count() > 0){
            mLoadedList = getDao().loadAll();
        }

        return mLoadedList;
    }
    @Override
    void insert(ChampionData data) {
        if(!mLoadedList.contains(data))
            mLoadedList.add(data);

        getDao().insertOrReplace(data);
    }

    @Override
    void insert(ArrayList<ChampionData> arr) {

    }

    @Override
    void delete(ChampionData data) {
        if(mLoadedList.contains(data))
            mLoadedList.remove(data);

        getDao().delete(data);
    }
}
