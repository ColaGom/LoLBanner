package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-07.
 */
public class ResponseTo {

    private static ObjectMapper mapper = null;

    private  static  ObjectMapper getMapper(){
        if(mapper == null) mapper = new ObjectMapper();
        return mapper;
    }

    public static Summoner summoner(Response<ResponseBody> response, String userName) throws Exception {
        JsonNode node = getMapper().readValue(response.body().string(), JsonNode.class);

        return getMapper().treeToValue(node.get(userName), Summoner.class);
    }

    public static StatSummary statSummary(Response<ResponseBody> response) throws Exception{

        return  getMapper().readValue(response.body().string(), StatSummary.class);
    }

    public static List<RankInfo> rankInfo(Response<ResponseBody> response, List<String> userIds) throws Exception{
        JsonNode node = getMapper().readValue(response.body().string(), JsonNode.class);

        List<RankInfo> result = new ArrayList<>();

        for(String userId:userIds)
        {
            result.add(getMapper().treeToValue(node.get(userId), RankInfo.class));
        }
        return result;
    }

    public static CurrentGame currentGame(Response<ResponseBody> response) throws Exception{

        return getMapper().readValue(response.body().string(), CurrentGame.class);
    }

    public static String latestVersion(Response<ResponseBody> response) throws  Exception{
        List<String> versions = getMapper().readValue(response.body().string(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, String.class));

        return versions.get(0);
    }

    public static List<Champion> champions(Response<ResponseBody> response) throws  Exception {
        JsonNode arrNode =getMapper().readTree(response.body().string()).get("data");

        List<Champion> result = new ArrayList<>();

        if(arrNode.isArray()){
            for(JsonNode node : arrNode){
                Logger.d(node.asText());
            }
        }

        return result;
    }

    public static List<Champion> champions(String json) throws  Exception {
        JsonNode arrNode =getMapper().readTree(json).get("data");

        List<Champion> result = new ArrayList<>();

        if(arrNode.isArray()){
            for(JsonNode node : arrNode){
                Logger.d(node.asText());
            }
        }

        return result;
    }
}
