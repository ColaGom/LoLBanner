package com.cbstudio.lolbanner;

import android.content.Context;

import com.cbstudio.lolbanner.model.Champion;
import com.cbstudio.lolbanner.model.ResponseTo;
import com.cbstudio.lolbanner.model.UserPref;
import com.cbstudio.lolbanner.net.LOLClient;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-11.
 */

//TODO : implements Only VERSION_CHECK continue Next!!!
public class DataDragonBinder implements Callback<ResponseBody> {

//    SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
//    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//    pDialog.setTitleText("Loading");
//    pDialog.setCancelable(false);
//    pDialog.show();

    SweetAlertDialog mDialog;

    private Context context;
    private STEP currentStep;

    public DataDragonBinder(Context context)
    {
        this.context = context;
        mDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.setCancelable(false);
    }

    private String stepToMessage()
    {
        String msg = "";

        switch (currentStep)
        {
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

    private void updateDialog()
    {
        mDialog.setTitleText(stepToMessage());
    }

    public void load(){
        mDialog.show();
        currentStep = STEP.VERSION_CHECK;
        LOLClient.getLatestVersion(this);
        execute();
    }

    private void nextStep(){
        currentStep = currentStep.next();
        execute();
    }

    private void execute(){
        updateDialog();
        switch (currentStep)
        {
            case VERSION_CHECK:
                LOLClient.getLatestVersion(this);
                break;
            case SYNC_CHAMPION:

                break;
            case LOAD_CHAMPION:

                break;
        }
    }

    public void stop(){

    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        switch (currentStep)
        {
            case VERSION_CHECK:
                try {
                    String latestVersion = ResponseTo.latestVersion(response);
                    if(UserPref.getLatestVersion().equals(latestVersion)){
                        return;
                    }
                    nextStep();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case SYNC_CHAMPION:
                break;
            case LOAD_CHAMPION:
                try {
                    List<Champion> champions = ResponseTo.champions(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

        if(!currentStep.isLast())
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

        public STEP next()
        {
            return vals[(this.ordinal()+1) % vals.length];
        }

        public boolean isLast()
        {
            return this == SYNC_CHAMPION;
        }
    }

    public interface Listener
    {
        void onCompleteDragon(Boolean state);
    }
}
