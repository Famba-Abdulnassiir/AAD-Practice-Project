package com.example.myapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class LeaderAdpter extends RecyclerView.Adapter<LeaderAdpter.LeaderViewHolder> {

    private final List<LeaderList> leaderlist;
    private final Context context;

    public static class LeaderViewHolder extends RecyclerView.ViewHolder{

        public ImageView budgeImage;
        public TextView name;
        public TextView score;
        private LeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            budgeImage = itemView.findViewById(R.id.budgeimageleader);
            name = itemView.findViewById(R.id.nameleader);
            score = itemView.findViewById(R.id.scoreleader);
        }
    }
    public LeaderAdpter(Context context, List<LeaderList> leaderLists) {
        this.leaderlist = leaderLists;
        this.context = context;
    }

    @NonNull
    @Override
    public LeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderitem,parent,false);
       return new LeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderViewHolder holder, int position) {
        LeaderList lists = leaderlist.get(position);
        holder.name.setText(lists.getName());
        holder.score.setText(lists.getScore() +" "+ lists.getCountry()+" ");
        Picasso.get().load(lists.getBadgeUrl()).into(holder.budgeImage);
    }

    @Override
    public int getItemCount() {
        if(leaderlist != null){
            return leaderlist.size();
        }
        return 0;
    }

}
