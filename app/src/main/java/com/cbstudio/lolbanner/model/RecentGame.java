package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentGame {

    @JsonProperty("games")
    private Game game;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Game
    {
        @JsonProperty("fellowPlayers")
        private Player[] players;

        @JsonProperty("gameType")
        private String gameType;

        @JsonProperty("stats")
        private Stat stat;

        @JsonProperty("gameId")
        private String gameId;
        @JsonProperty("ipEarned")
        private String ipEarned;
        @JsonProperty("spell1")
        private String spell1;
        @JsonProperty("teamId")
        private String teamId;
        @JsonProperty("spell2")
        private String spell2;
        @JsonProperty("gameMode")
        private String gameMode;
        @JsonProperty("mapId")
        private String mapId;
        @JsonProperty("level")
        private String level;
        @JsonProperty("invalid")
        private String invalid;
        @JsonProperty("subType")
        private String createDate;
        @JsonProperty("createDate")
        private String subType;
        @JsonProperty("championId")
        private String championId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Player
    {
        @JsonProperty("championId")
        private String champonId;
        @JsonProperty("teamId")
        private String temdId;
        @JsonProperty("summonerId")
        private String summonerId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stat
    {
        @JsonProperty("totalDamageDealtToChampions")
        private String totalDamageDealtToChampions;
        @JsonProperty("item2")
        private String item2;
        @JsonProperty("goldEarned")
        private String goldEarned;
        @JsonProperty("item1")
        private String item1;
        @JsonProperty("wardPlaced")
        private String wardPlaced;
        @JsonProperty("totalDamageTaken")
        private String totalDamageTaken;
        @JsonProperty("item0")
        private String item0;
        @JsonProperty("trueDamageDealtPlayer")
        private String trueDamageDealtPlayer;
        @JsonProperty("physicalDamageDealtPlayer")
        private String physicalDamageDealtPlayer;
        @JsonProperty("visionWardsBought")
        private String visionWardsBought;
        @JsonProperty("trueDamageDealtToChampions")
        private String trueDamageDealtToChampions;
        @JsonProperty("killingSprees")
        private String killingSprees;
        @JsonProperty("playerRole")
        private String playerRole;
        @JsonProperty("totalUnitsHealed")
        private String totalUnitsHealed;
        @JsonProperty("bountyLevel")
        private String bountyLevel;
        @JsonProperty("playerPosition")
        private String playerPosition;
        @JsonProperty("level")
        private String level;
        @JsonProperty("neutralMinionsKilledYourJungle")
        private String neutralMinionsKilledYourJungle;
        @JsonProperty("magicDamageDealtToChampions")
        private String magicDamageDealtToChampions;
        @JsonProperty("turretsKilled")
        private String turretsKilled;
        @JsonProperty("magicDamageDealtPlayer")
        private String magicDamageDealtPlayer;
        @JsonProperty("neutralMinionsKilledEnemyJungle")
        private String neutralMinionsKilledEnemyJungle;
        @JsonProperty("assists")
        private String assists;
        @JsonProperty("magicDamageTaken")
        private String magicDamageTaken;
        @JsonProperty("numDeaths")
        private String numDeaths;
        @JsonProperty("totalTimeCrowdControlDealt")
        private String totalTimeCrowdControlDealt;
        @JsonProperty("largestMultiKill")
        private String largestMultiKill;
        @JsonProperty("physicalDamageTaken")
        private String physicalDamageTaken;
        @JsonProperty("team")
        private String team;
        @JsonProperty("win")
        private String win;
        @JsonProperty("totalDamageDealt")
        private String totalDamageDealt;
        @JsonProperty("largestKillingSpree")
        private String largestKillingSpree;
        @JsonProperty("totalHeal")
        private String totalHeal;
        @JsonProperty("item4")
        private String item4;
        @JsonProperty("item3")
        private String item3;
        @JsonProperty("item6")
        private String item6;
        @JsonProperty("item5")
        private String item5;
        @JsonProperty("minionsKilled")
        private String minionsKilled;
        @JsonProperty("timePlayed")
        private String timePlayed;
        @JsonProperty("wardKilled")
        private String wardKilled;
        @JsonProperty("physicalDamageDealtToChampions")
        private String physicalDamageDealtToChampions;
        @JsonProperty("championsKilled")
        private String championsKilled;
        @JsonProperty("trueDamageTaken")
        private String trueDamageTaken;
        @JsonProperty("goldSpent")
        private String goldSpent;
        @JsonProperty("neutralMinionsKilled")
        private String neutralMinionsKilled;
    }
}
