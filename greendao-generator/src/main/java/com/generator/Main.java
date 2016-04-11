package com.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {
    public static  void main(String[] args){
        Schema schema = new Schema(1, "com.cbstudio.lolbanner.model.dao");

        Entity championData = schema.addEntity("ChampionData");
        championData.addIdProperty();
        championData.addStringProperty("key");
        championData.addStringProperty("title");
        championData.addStringProperty("name");
        championData.addStringProperty("tags");
        championData.addStringProperty("image");

        try {
            DaoGenerator dg = new DaoGenerator();
            dg.generateAll(schema, "../app/src/main/java");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
