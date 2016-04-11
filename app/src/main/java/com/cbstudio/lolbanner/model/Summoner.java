package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-07.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summoner {
    @JsonProperty("id")
    private String id;
    @JsonProperty("profileIconId")
    private String profileIconId;
    @JsonProperty("summonerLevel")
    private String summonerLevel;
    private String summonerName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[id] : " + id);
        sb.append("[profileIconId] : " + profileIconId);
        sb.append("[summonerLevel] : " + summonerLevel);
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public String getProfileIconId() {
        return profileIconId;
    }

    public String getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerName(String name) {
        summonerName = name;
    }

    public String getSummonerName() {
        return summonerName;
    }
}
