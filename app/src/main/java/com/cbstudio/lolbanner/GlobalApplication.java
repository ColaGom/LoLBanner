package com.cbstudio.lolbanner;

import android.app.Application;

import com.cbstudio.lolbanner.controller.Master;
import com.cbstudio.lolbanner.model.UserPref;
import com.cbstudio.lolbanner.net.LOLClient;
import com.orhanobut.logger.Logger;
/**
 * Created by Colabear on 2016-04-07.
 */
public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        UserPref.init(this);
        LOLClient.init(this);
        Master.getInstance().init(this);
        Logger.init(Const.TAG);

    }
}
