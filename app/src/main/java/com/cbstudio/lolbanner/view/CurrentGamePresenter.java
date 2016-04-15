package com.cbstudio.lolbanner.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cbstudio.lolbanner.Const;
import com.cbstudio.lolbanner.R;
import com.cbstudio.lolbanner.controller.Master;
import com.cbstudio.lolbanner.model.CurrentGame;
import com.cbstudio.lolbanner.model.dao.ChampionData;
import com.cbstudio.lolbanner.net.DataDragonUrlBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Colabear on 2016-04-11.
 */
public class CurrentGamePresenter {

    private CurrentGame currentGame;

    public CurrentGamePresenter(CurrentGame currentGame){
        this.currentGame = currentGame;
    }

    public View getView(LayoutInflater inflater)
    {
        View rootView = inflater.inflate(R.layout.row_currentgame, null);
        RootViewHoler viewHoler = new RootViewHoler();
        viewHoler.bind(rootView);

        CurrentGame.Player[] players = currentGame.getParticipants();

        for(CurrentGame.Player player:players)
        {
            View child = getPlayerRow(player, inflater);
            if(player.getTeamId().equals(Const.TEAM_LEFT)){
                viewHoler.rootLeft.addView(child);
            }else{
                viewHoler.rootRight.addView(child);
            }
        }
        return rootView;
    }

    private View getPlayerRow(CurrentGame.Player player, LayoutInflater inflater)
    {
        View rootView = inflater.inflate(R.layout.row_current_player, null);

        PlayerViewHolder viewHolder = new PlayerViewHolder();

        viewHolder.bind(rootView);
        viewHolder.setView(player , inflater.getContext());

        return rootView;
    }

    class RootViewHoler
    {
        @Bind(R.id.root_left)
        LinearLayout rootLeft;
        @Bind(R.id.root_right)
        LinearLayout rootRight;

        void bind(View view)
        {
            ButterKnife.bind(this, view);
        }
    }

    class PlayerViewHolder
    {
        @Bind(R.id.iv_champ)
        ImageView ivChamp;
        @Bind(R.id.tv_tier)
        TextView tvTier;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_kda)
        TextView tvKda;

        void bind(View view)
        {
            ButterKnife.bind(this, view);
        }

        void setView(CurrentGame.Player player, Context context)
        {
            tvName.setText(player.getSummonerName());
            tvKda.setText(player.getChampionId());

            DataDragonUrlBuilder builder = new DataDragonUrlBuilder();
            ChampionData championData = Master.getInstance().getChampionDataLoader().get(player.getChampionId());
            String url = builder.campions(championData.getName()).build();
            Glide.with(context).load(url).into(ivChamp);
        }
    }
}
