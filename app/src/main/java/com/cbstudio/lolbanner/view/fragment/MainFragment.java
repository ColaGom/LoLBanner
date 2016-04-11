package com.cbstudio.lolbanner.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cbstudio.lolbanner.R;
import com.cbstudio.lolbanner.Values;
import com.cbstudio.lolbanner.model.CurrentGame;
import com.cbstudio.lolbanner.model.ResponseTo;
import com.cbstudio.lolbanner.net.LOLClient;
import com.cbstudio.lolbanner.view.CurrentGamePresenter;

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
public class MainFragment extends BaseFragment {

    @Bind(R.id.tv_sumonner)
    TextView tvSumonner;

    @Bind(R.id.tv_state)
    TextView tvState;

    @Bind(R.id.root_current)
    FrameLayout rootCurrent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, rootView);
        tvSumonner.setText(Values.summoner.getSummonerName());

        LOLClient.getCurrentGame(Values.summoner.getId(), new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    rootCurrent.removeAllViews();
                    CurrentGame currentGame = ResponseTo.currentGame(response);
                    CurrentGamePresenter presenter = new CurrentGamePresenter(currentGame);
                    View child = presenter.getView(LayoutInflater.from(getContext()));
                    rootCurrent.addView(child);
                } catch (Exception e) {
                    e.printStackTrace();
                    tvState.setText(getString(R.string.label_notfount_game));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                tvState.setText(getString(R.string.label_notfount_game));
            }
        });

        return rootView;
    }

    @OnClick(R.id.btn_widget)
    void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_widget:
                //TODO : setting to widget
                break;
        }
    }

}
