package com.cbstudio.lolbanner.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbstudio.lolbanner.R;
import com.cbstudio.lolbanner.Values;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Colabear on 2016-04-11.
 */
public class MainFragment extends BaseFragment {

    @Bind(R.id.tv_sumonner)
    TextView tvSumonner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, rootView);
        tvSumonner.setText(Values.summoner.getSummonerName());

        return rootView;
    }

    @OnClick(R.id.btn_widget)
    void onClick(View view)
    {
        int id = view.getId();

        switch (id)
        {
            case R.id.btn_widget:
                //TODO : setting to widget
                break;
        }
    }

}
