package com.cbstudio.lolbanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Champion {
    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("partype")
    private  String partype;

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public String getKey() {
        return key;
    }

    public String getPartype() {
        return partype;
    }

    public String getTag() {
        return tag;
    }

    public String getTitle() {
        return title;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class  Image
    {
        @JsonProperty("full")
        private String full;
        @JsonProperty("sprite")
        private String sprite;
    }
}
