package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-07.
 */
public class ResponseTo {

    public static Summoner summoner(Response<ResponseBody> response, String userName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(response.body().string() , JsonNode.class);

        return mapper.treeToValue(node.get(userName), Summoner.class);
    }

    public static StatSummary statSummary(Response<ResponseBody> response) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        return  mapper.readValue(response.body().string(), StatSummary.class);
    }
}
