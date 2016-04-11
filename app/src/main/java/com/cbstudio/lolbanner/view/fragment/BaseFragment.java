package com.cbstudio.lolbanner.view.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.cbstudio.lolbanner.view.activity.MainActivity;

/**
 * Created by Colabear on 2016-04-11.
 */
public class BaseFragment extends Fragment {

    protected MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity)context;
    }
}
