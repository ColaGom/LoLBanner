package com.cbstudio.lolbanner.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Colabear on 2016-04-07.
 */
public interface API {
    @GET("/shards")
    Call<ResponseBody> getServerStatus();

    @GET("/api/lol/{region}/v1.4/summoner/by-name/{name}")
    Call<ResponseBody> getSummonerByName(@Path("region") String region, @Path("name") String name, @Query("api_key") String apiKey);

    @GET("/championmastery/location/{region}/player/{playerId}/champion/{championId}")
    Call<ResponseBody> getCampionMastery(@Path("region") String region, @Path("playerId") String playerId, @Path("championId") String championId, @Query("api_key") String apiKey);

    @GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
    Call<ResponseBody> getStatsRank(@Path("region") String region, @Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    @GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
    Call<ResponseBody> getStatsSummary(@Path("region") String region, @Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    @GET("/observer-mode/rest/consumer/getSpectatorGameInfo/{region}/{summonerId}")
    Call<ResponseBody> getCurrentGame(@Path("region") String region,@Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    @GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    Call<ResponseBody> getRecentGame(@Path("region") String region,@Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    /**
     * get summoners rank info
     * @param region region
     * @param summonerIds support comma sepratated list of Ids. limit 10.
     * @param apiKey
     * @return
     */
    @GET("/api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
    Call<ResponseBody> getRankInfo(@Path("region") String region,@Path("summonerIds") String summonerIds, @Query("api_key") String apiKey);

}
