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

    /**
     * 서버 상태 조회
     * @return
     */
    @GET("/shards")
    Call<ResponseBody> getServerStatus();

    /**
     * 소환사 정보 조회
     * @param region
     * @param name
     * @param apiKey
     * @return
     */
    @GET("/api/lol/{region}/v1.4/summoner/by-name/{name}")
    Call<ResponseBody> getSummonerByName(@Path("region") String region, @Path("name") String name, @Query("api_key") String apiKey);

    /**
     * 소환사 챔피언 플레이 정보 조회
     * @param region
     * @param playerId
     * @param championId
     * @param apiKey
     * @return
     */
    @GET("/championmastery/location/{region}/player/{playerId}/champion/{championId}")
    Call<ResponseBody> getCampionMastery(@Path("region") String region, @Path("playerId") String playerId, @Path("championId") String championId, @Query("api_key") String apiKey);

    /**
     * 소환사 랭크(팀, 개인) 플레이 정보 조회
     * @param region
     * @param summonerId
     * @param apiKey
     * @return
     */
    @GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
    Call<ResponseBody> getStatsRank(@Path("region") String region, @Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    /**
     * 소환사 일반, 랭크 등 플레이 정보 전체 조회
     * @param region
     * @param summonerId
     * @param apiKey
     * @return
     */
    @GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
    Call<ResponseBody> getStatsSummary(@Path("region") String region, @Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    /**
     * 현재 진행중인 게임 정보 조회
     * @param region
     * @param summonerId
     * @param apiKey
     * @return
     */
    @GET("/observer-mode/rest/consumer/getSpectatorGameInfo/{region}/{summonerId}")
    Call<ResponseBody> getCurrentGame(@Path("region") String region,@Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    /**
     * 소환사 최근 30게임 조회
     * @param region
     * @param summonerId
     * @param apiKey
     * @return
     */
    @GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    Call<ResponseBody> getRecentGame(@Path("region") String region,@Path("summonerId") String summonerId, @Query("api_key") String apiKey);

    /**
     * 소환사 랭크 정보 조회
     * @param region region
     * @param summonerIds support comma sepratated list of Ids. limit 10.
     * @param apiKey
     * @return
     */
    @GET("/api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
    Call<ResponseBody> getRankInfo(@Path("region") String region,@Path("summonerIds") String summonerIds, @Query("api_key") String apiKey);


    /**
     * 최신 버전 조회
     * @param region
     * @return
     */
    @GET("/api/lol/static-data/{region}/v1.2/versions")
    Call<ResponseBody> getRankInfo(@Path("region") String region);
}
