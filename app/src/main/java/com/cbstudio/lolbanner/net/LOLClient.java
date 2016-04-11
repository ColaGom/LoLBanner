package com.cbstudio.lolbanner.net;

import android.content.Context;

import com.cbstudio.lolbanner.Const;
import com.cbstudio.lolbanner.R;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Colabear on 2016-04-07.
 */
public class LOLClient  {

    private  static String URL_SERVER;
    private  static String URL_SERVER_GLOBAL;
    private static  String REGION;

    private static API api;
    private static API globalApi;
    public static  void init(Context context){
        URL_SERVER = context.getString(R.string.url_server);
        URL_SERVER_GLOBAL = context.getString(R.string.url_server_global);
        REGION = context.getString(R.string.region);
    }

    protected synchronized static API getApi()
    {
        if(api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_SERVER)
                    .build();

            api = retrofit.create(API.class);
        }


        return api;
    }


    protected synchronized static API getGlobalApi()
    {
        if(globalApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_SERVER_GLOBAL)
                    .build();

            globalApi = retrofit.create(API.class);
        }

        return globalApi;
    }
    public static void getSummonerByName(String userName, Callback<ResponseBody> callback) {
        getApi().getSummonerByName(REGION, userName, Const.KEY_API).enqueue(callback);
    }

    public static void getStatsRank(String userId, Callback<ResponseBody> callback){
        getApi().getStatsRank(REGION, userId, Const.KEY_API).enqueue(callback);
    }

    public static void getStatsSummary(String userId, Callback<ResponseBody> callback)
    {
        getApi().getStatsSummary(REGION, userId, Const.KEY_API).enqueue(callback);
    }

    public static  void getServerStatus(Callback<ResponseBody> callback){
        getApi().getServerStatus().enqueue(callback);
    }

    public static void getCurrentGame(String userId, Callback<ResponseBody> callback)
    {
        getApi().getCurrentGame(REGION, userId, Const.KEY_API).enqueue(callback);
    }

    public static void getRecentGame(String userId, Callback<ResponseBody> callback)
    {
        getApi().getRecentGame(REGION, userId, Const.KEY_API).enqueue(callback);
    }

    public static void getRankInfo(String userIds, Callback<ResponseBody> callback)
    {
        getApi().getRankInfo(REGION, userIds, Const.KEY_API).enqueue(callback);
    }

    public static void getLatestVersion(Callback<ResponseBody> callback)
    {
        getGlobalApi().getLatestVersion(REGION, Const.KEY_API).enqueue(callback);
    }
}
