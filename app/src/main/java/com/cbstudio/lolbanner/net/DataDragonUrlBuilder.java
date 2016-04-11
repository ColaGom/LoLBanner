package com.cbstudio.lolbanner.net;

/**
 * Created by Colabear on 2016-04-08.
 */
public class DataDragonUrlBuilder {
    private final String URL = "http://ddragon.leagueoflegends.com/cdn/";
    //profileicon : http://ddragon.leagueoflegends.com/cdn/6.7.1/img/profileicon/588.png

    private StringBuilder stringBuilder;

    public DataDragonUrlBuilder() {
        stringBuilder = new StringBuilder(URL);
    }

    public DataDragonUrlBuilder profileIcons(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/profileicon/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder campions(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/champion/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder passiveAbilities(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/passive/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder summonerSpells(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/spell/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder items(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/item/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder masteries(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/mastery/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder runes(String value)
    {
        stringBuilder.append(String.format("6.7.1/img/rune/%s.png", value));
        return this;
    }


    public void clear()
    {
        stringBuilder.delete(URL.length(), stringBuilder.length());
    }

    public String build(){
        return stringBuilder.toString();
    }
}
