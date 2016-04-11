package com.cbstudio.lolbanner.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cbstudio.lolbanner.R;
import com.cbstudio.lolbanner.model.ResponseTo;
import com.cbstudio.lolbanner.model.Summoner;
import com.cbstudio.lolbanner.net.LOLClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Colabear on 2016-04-11.
 */
public class SettingFragment extends BaseFragment {
    @Bind(R.id.et_input)
    EditText etInput;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container ,false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_complete)
    void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_complete:
                final String name = etInput.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getContext(), R.string.msg_empty_name, Toast.LENGTH_SHORT).show();
                    return;
                }
                LOLClient.getSummonerByName(name, new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Summoner summoner = ResponseTo.summoner(response, name);
                            summoner.setSummonerName(name);
                            activity.onSuccessSetting(summoner);
                        } catch (Exception e) {
                            Toast.makeText(getContext(), R.string.msg_error_setting, Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getContext(), R.string.msg_error_setting, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
