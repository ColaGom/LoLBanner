package com.cbstudio.lolbanner.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.cbstudio.lolbanner.DataDragonBinder;
import com.cbstudio.lolbanner.R;
import com.cbstudio.lolbanner.Values;
import com.cbstudio.lolbanner.view.fragment.MainFragment;
import com.cbstudio.lolbanner.view.fragment.SettingFragment;
import com.cbstudio.lolbanner.model.Summoner;

public class MainActivity extends AppCompatActivity implements DataDragonBinder.Listener {

    @Override
    public void onCompleteDragon(Boolean state) {

    }

    enum FRAGMENT
    {
        SETTING,
        MAIN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataDragonBinder binder = new DataDragonBinder(this);
        binder.load();

        replaceFragment(FRAGMENT.SETTING);
    }

    public void onSuccessSetting(Summoner summoner)
    {
        Values.summoner = summoner;
        replaceFragment(FRAGMENT.MAIN);
    }

    private void replaceFragment(FRAGMENT frag)
    {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.root, getFragment(frag));

        transaction.commit();
    }

    private Fragment getFragment(FRAGMENT frag)
    {
        switch (frag)
        {
            case SETTING:
                return new SettingFragment();
            case MAIN:
                return new MainFragment();
            default:
                return new SettingFragment();
        }
    }
}
