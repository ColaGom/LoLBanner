package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatRanked {
    @JsonProperty("modifyDate")
    private String modifyDate;

    @JsonProperty("champions")
    private Champion[] champions;


    public Champion[] getChampions() {
        return champions;
    }

    public Champion getChampion(String id)
    {
        for(Champion champion:champions)
        {
            if(champion.getId().equals(id))
                return champion;
        }
        return null;
    }


    public String getModifyDate() {
        return modifyDate;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Champion {

        @JsonProperty("id")
        private String id;
        @JsonProperty("stats")
        private Stats stat;

        public Stats getStat() {
            return stat;
        }

        public String getId() {
            return id;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stats
    {
        @JsonProperty("totalDeathsPerSession")
        private String totalDeathsPerSession;
        @JsonProperty("totalSessionsPlayed")
        private String totalSessionsPlayed;
        @JsonProperty("totalDamageTaken")
        private String totalDamageTaken;
        @JsonProperty("totalQuadraKills")
        private String totalQuadraKills;
        @JsonProperty("totalTripleKills")
        private String totalTripleKills;
        @JsonProperty("totalMinionKills")
        private String totalMinionKills;
        @JsonProperty("maxChampionsKilled")
        private String maxChampionsKilled;
        @JsonProperty("totalDoubleKills")
        private String totalDoubleKills;
        @JsonProperty("totalPhysicalDamageDealt")
        private String totalPhysicalDamageDealt;
        @JsonProperty("totalChampionKills")
        private String totalChampionKills;
        @JsonProperty("totalAssists")
        private String totalAssists;
        @JsonProperty("mostChampionKillsPerSession")
        private String mostChampionKillsPerSession;
        @JsonProperty("totalDamageDealt")
        private String totalDamageDealt;
        @JsonProperty("totalFirstBlood")
        private String totalFirstBlood;
        @JsonProperty("totalSessionsLost")
        private String totalSessionsLost;
        @JsonProperty("totalSessionsWon")
        private String totalSessionsWon;
        @JsonProperty("totalMagicDamageDealt")
        private String totalMagicDamageDealt;
        @JsonProperty("totalGoldEarned")
        private String totalGoldEarned;
        @JsonProperty("totalPentaKills")
        private String totalPentaKills;
        @JsonProperty("maxNumDeaths")
        private String maxNumDeaths;
        @JsonProperty("mostSpellsCast")
        private String mostSpellsCast;
        @JsonProperty("totalTurretsKilled")
        private String totalTurretsKilled;
        @JsonProperty("totalUnrealKills")
        private String totalUnrealKills;

        public String getTotalSessionsPlayed() {
            return totalSessionsPlayed;
        }

        public String getTotalSessionsWon() {
            return totalSessionsWon;
        }

        public String getTotalSessionsLost() {
            return totalSessionsLost;
        }

        public String getMaxChampionsKilled() {
            return maxChampionsKilled;
        }

        public String getTotalDeathsPerSession() {
            return totalDeathsPerSession;
        }

        public String getTotalAssists() {
            return totalAssists;
        }

        public String getTotalChampionKills() {
            return totalChampionKills;
        }
    }

}
