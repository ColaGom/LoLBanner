package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-07.
 */
public class ResponseTo {

    public static Summoner summoner(Response<ResponseBody> response, String userName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(response.body().string() , JsonNode.class);

        return mapper.treeToValue(node.get(userName), Summoner.class);
    }

    public static StatSummary statSummary(Response<ResponseBody> response) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        return  mapper.readValue(response.body().string(), StatSummary.class);
    }

    public static List<RankInfo> rankInfo(Response<ResponseBody> response, List<String> userIds) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readValue(response.body().string(), JsonNode.class);

        List<RankInfo> result = new ArrayList<>();

        for(String userId:userIds)
        {
            result.add(mapper.treeToValue(node.get(userId), RankInfo.class));
        }
        return result;
    }

    public static CurrentGame currentGame(Response<ResponseBody> response) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.body().string(), CurrentGame.class);
    }
}
