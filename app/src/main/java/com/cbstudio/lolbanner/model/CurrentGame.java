package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentGame {

    @JsonProperty("gameLength")
    private String gameLength;
    @JsonProperty("gameMode")
    private String gameMode;
    @JsonProperty("mapId")
    private String mapId;
    @JsonProperty("gameType")
    private String gameType;
    @JsonProperty("gameId")
    private String gameId;
    @JsonProperty("observers")
    private Observer observers;
    @JsonProperty("gameQueueConfigId")
    private String gameQueueConfigId;
    @JsonProperty("gameStartTime")
    private String gameStartTime;
    @JsonProperty("platformId")
    private String platformId;
    @JsonProperty("participants")
    private Player[] participants;

    public Observer getObservers() {
        return observers;
    }

    public Player[] getParticipants() {
        return participants;
    }

    public String getGameId() {
        return gameId;
    }

    public String getGameLength() {
        return gameLength;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public String getGameStartTime() {
        return gameStartTime;
    }

    public String getGameType() {
        return gameType;
    }

    public String getMapId() {
        return mapId;
    }

    public String getPlatformId() {
        return platformId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rune
    {
        @JsonProperty("count")
        private String count;
        @JsonProperty("runeId")
        private String runeId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Mastery
    {
        @JsonProperty("rank")
        private String rank;
        @JsonProperty("masteryId")
        private String masteryId;

        public String getMasteryId() {
            return masteryId;
        }
        public String getRank() {
            return rank;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Player
    {
        @JsonProperty("masteries")
        private Mastery[] masteries;
        @JsonProperty("bot")
        private boolean bot;
        @JsonProperty("runes")
        private Rune[] runes;
        @JsonProperty("spell2Id")
        private String spell2Id;
        @JsonProperty("profileIconId")
        private String profileIconId;
        @JsonProperty("summonerName")
        private String summonerName;
        @JsonProperty("championId")
        private String championId;
        @JsonProperty("teamId")
        private String teamId;
        @JsonProperty("summonerId")
        private String summonerId;
        @JsonProperty("spell1Id")
        private String spell1Id;

        public String getChampionId() {
            return championId;
        }

        public String getProfileIconId() {
            return profileIconId;
        }

        public String getSpell1Id() {
            return spell1Id;
        }

        public String getSpell2Id() {
            return spell2Id;
        }

        public String getSummonerId() {
            return summonerId;
        }

        public String getSummonerName() {
            return summonerName;
        }

        public String getTeamId() {
            return teamId;
        }

        public boolean isBot() {
            return bot;
        }

        public Mastery[] getMasteries() {
            return masteries;
        }

        public Rune[] getRunes() {
            return runes;
        }
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Observer
    {
        @JsonProperty("encryptionKey")
        private String encryptionKey;

        public String getEncryptionKey() {
            return encryptionKey;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BannedChampion
    {
        @JsonProperty("pickTurn")
        private String pickTurn;
        @JsonProperty("championId")
        private String championId;
        @JsonProperty("teamId")
        private String teamId;

        public String getTeamId() {
            return teamId;
        }

        public String getChampionId() {
            return championId;
        }

        public String getPickTurn() {
            return pickTurn;
        }
    }
}
