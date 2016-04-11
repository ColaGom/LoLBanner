package com.cbstudio.lolbanner.net;

import com.cbstudio.lolbanner.Const;

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

    private void appendVersion()
    {
        stringBuilder.append(Const.DATA_DRAGON_VERSION);
    }

    public DataDragonUrlBuilder profileIcons(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/profileicon/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder campions(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/champion/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder passiveAbilities(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/passive/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder summonerSpells(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/spell/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder items(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/item/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder masteries(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/mastery/%s.png", value));
        return this;
    }

    public DataDragonUrlBuilder runes(String value)
    {
        appendVersion();
        stringBuilder.append(String.format("/img/rune/%s.png", value));
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
