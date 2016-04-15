package com.cbstudio.lolbanner.controller;

import android.content.Context;

/**
 * Created by Colabear on 2016-04-15.
 */
public class Master {
    private static Master sInstance = null;

    public static Master getInstance()
    {
        if(sInstance == null) sInstance = new Master();

        return sInstance;
    }
    private ChampionDataLoader championDataLoader;

    public void init(Context context)
    {
        championDataLoader = new ChampionDataLoader();
        championDataLoader.init(context);
    }

    public ChampionDataLoader getChampionDataLoader() {
        return championDataLoader;
    }
}
