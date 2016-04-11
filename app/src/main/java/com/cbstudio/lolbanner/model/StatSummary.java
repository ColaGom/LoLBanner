package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-08.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatSummary {

    private  final  String TYPE_COOP_AI = "CoopVsAI";
    private  final  String TYPE_UNRANK = "Unranked";
    private  final  String TYPE_RANK = "RankedSolo5x5";


    @JsonProperty("summonerId")
    private String summonerId;

    public StatSummary()
    {

    }

    @Override
    public String toString() {
        return "[StatSummary]" + summonerId;
    }

    @JsonProperty("playerStatSummaries")
    private PlayerStatSummaries[] playerStatSummaries;

    public PlayerStatSummaries getUnrankedStat()
    {
        for(PlayerStatSummaries summaries:playerStatSummaries)
        {
            if(summaries.getType().equals(TYPE_UNRANK)){
                return summaries;
            }
        }
        return null;
    }

    public PlayerStatSummaries getRankedStat()
    {
        for(PlayerStatSummaries summaries:playerStatSummaries)
        {
            if(summaries.getType().equals(TYPE_RANK)){
                return summaries;
            }
        }
        return null;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayerStatSummaries {

        @JsonProperty("playerStatSummaryType")
        private String playerStatSummaryType;
        @JsonProperty("aggregatedStats")
        private AggregatedStat aggregatedStats;
        @JsonProperty("wins")
        private String wins;
        @JsonProperty("modifyDate")
        private String modifyDate;
        @JsonProperty("losses")
        private  String losses;

        public PlayerStatSummaries(){

        }

        public String getLosses() {
            return losses;
        }

        public String getType()
        {
            return playerStatSummaryType;
        }

        public AggregatedStat getAggregatedStats()
        {
            return aggregatedStats;
        }

        public String getWins()
        {
            return wins;
        }

        public String getModifyDate()
        {
            return modifyDate;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AggregatedStat {

        @JsonProperty("totalChampionKills")
        private String totalChampionKills;
        @JsonProperty("totalAssists")
        private String totalAssists;
        @JsonProperty("totalTurretsKilled")
        private String totalTurretsKilled;
        @JsonProperty("totalNeutralMinionsKilled")
        private String totalNeutralMinionsKilled;
        @JsonProperty("totalMinionKills")
        private String totalMinionKills;

        public AggregatedStat(){

        }

        public String getTotalChampionKills(){
            return totalChampionKills;
        }

        public String getTotalAssists() {
            return totalAssists;
        }

        public String getTotalMinionKills() {
            return totalMinionKills;
        }

        public String getTotalNeutralMinionsKilled() {
            return totalNeutralMinionsKilled;
        }

        public String getTotalTurretsKilled() {
            return totalTurretsKilled;
        }
    }
}
