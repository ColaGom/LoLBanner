package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RankInfo {
    @JsonProperty("queue")
    private String queue;
    @JsonProperty("name")
    private String name;
    @JsonProperty("entries")
    private Entry entries;
    @JsonProperty("tier")
    private String tier;

    public Entry getEntries() {
        return entries;
    }

    public String getName() {
        return name;
    }

    public String getQueue() {
        return queue;
    }

    public String getTier() {
        return tier;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry
    {
        @JsonProperty("leaguePoints")
        private String leaguePoints;
        @JsonProperty("isFreshBlood")
        private boolean isFreshBlood;
        @JsonProperty("isHotStreak")
        private boolean isHotStreak;
        @JsonProperty("division")
        private String division;
        @JsonProperty("isInactive")
        private boolean isInactive;
        @JsonProperty("isVeteran")
        private boolean isVeteran;
        @JsonProperty("losses")
        private String losses;
        @JsonProperty("playerOrTeamName")
        private String playerOrTeamName;
        @JsonProperty("playerOrTeamId")
        private String playerOrTeamId;
        @JsonProperty("wins")
        private String wins;

        public String getDivision() {
            return division;
        }

        public String getLeaguePoints() {
            return leaguePoints;
        }

        public String getLosses() {
            return losses;
        }

        public String getPlayerOrTeamId() {
            return playerOrTeamId;
        }

        public String getPlayerOrTeamName() {
            return playerOrTeamName;
        }

        public String getWins() {
            return wins;
        }

        public boolean isFreshBlood() {
            return isFreshBlood;
        }

        public boolean isHotStreak() {
            return isHotStreak;
        }

        public boolean isInactive() {
            return isInactive;
        }

        public boolean isVeteran() {
            return isVeteran;
        }
    }
}
