package com.cbstudio.lolbanner;

import android.content.Context;

import com.cbstudio.lolbanner.controller.Master;
import com.cbstudio.lolbanner.model.ResponseTo;
import com.cbstudio.lolbanner.model.UserPref;
import com.cbstudio.lolbanner.model.dao.ChampionData;
import com.cbstudio.lolbanner.net.DataDragonUrlBuilder;
import com.cbstudio.lolbanner.net.LOLClient;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-11.
 */

public class DataDragonBinder implements Callback<ResponseBody> {

    SweetAlertDialog mDialog;

    private Context context;
    private STEP currentStep;

    public DataDragonBinder(Context context) {
        this.context = context;
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.setCancelable(false);
    }

    private String stepToMessage() {
        String msg = "";

        switch (currentStep) {
            case VERSION_CHECK:
                msg = context.getString(R.string.msg_version_check);
                break;
            case LOAD_CHAMPION:
                msg = context.getString(R.string.msg_load_champion);
                break;

            case SYNC_CHAMPION:
                msg = context.getString(R.string.msg_sync_champion);
                break;
        }

        return msg;
    }

    private void updateDialog() {
        mDialog.setTitleText(stepToMessage());
    }

    public void load() {
        Logger.d("start load");
        mDialog.show();
        currentStep = STEP.VERSION_CHECK;
        execute();
    }

    private void nextStep() {
        currentStep = currentStep.next();
        execute();
    }

    private void execute() {
        updateDialog();
        switch (currentStep) {
            case VERSION_CHECK:
                LOLClient.getLatestVersion(this);
                break;
            case SYNC_CHAMPION:

                break;
            case LOAD_CHAMPION:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = new DataDragonUrlBuilder().chapionsJson().build();
                        try {
                            JSONObject json = JsonReader.readJsonFromUrl(url).getJSONObject("data");
                            Iterator iterator = json.keys();
                            List<ChampionData> championDatas = new ArrayList<ChampionData>();
                            while(iterator.hasNext()){
                                String name = (String)iterator.next();
                                JSONObject object = json.getJSONObject(name);
                                ChampionData championData = new ChampionData();
                                championData.setKey(object.getString("key"));
                                championData.setImage(object.getJSONObject("image").getString("full"));
                                championData.setTitle(object.getString("title"));
                                championData.setName(name);
                                championData.setTags(object.getString("tags"));
                                championDatas.add(championData);
                            }
                            Master.getInstance().getChampionDataLoader().replaceAll(championDatas);
                            nextStep();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }
    }

    public void stop() {
        if(mDialog.isShowing()) {
            mDialog.dismiss();
        }

        Logger.d("stop");

        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(context.getString(R.string.msg_complete_sync))
                .setContentText(context.getString(R.string.msg_desc_sync))
                .show();
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        switch (currentStep) {
            case VERSION_CHECK:
                try {
                    String latestVersion = ResponseTo.latestVersion(response);
                    if (UserPref.getLatestVersion().equals(latestVersion)) {
                        stop();
                        return;
                    }

                    UserPref.putLatestVersion(latestVersion);
                    nextStep();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case SYNC_CHAMPION:
                break;
            case LOAD_CHAMPION:
//                try {
//                    List<Champion> champions = ResponseTo.champions(response);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                break;
        }

        if (!currentStep.isLast())
            nextStep();
        else
            mDialog.dismiss();
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        mDialog.dismiss();
    }

    public enum STEP {
        VERSION_CHECK,
        LOAD_CHAMPION,
        SYNC_CHAMPION;

        private static STEP[] vals = values();

        public STEP next() {
            return vals[(this.ordinal() + 1) % vals.length];
        }

        public boolean isLast() {
            return this == SYNC_CHAMPION;
        }
    }

    public interface Listener {
        void onCompleteDragon(Boolean state);
    }
}
