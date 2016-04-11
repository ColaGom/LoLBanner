package com.cbstudio.lolbanner;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Colabear on 2016-04-11.
 */
public class DataDragonTask extends AsyncTask<Void, DataDragonTask.STEP, Void> {

    private Context context;
    private STEP currentStep;

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

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onProgressUpdate(STEP... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public enum STEP{
        VERSION_CHECK,
        LOAD_CHAMPION,
        SYNC_CHAMPION
    }
}
