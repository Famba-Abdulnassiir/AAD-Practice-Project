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

public class SkillsIqAdpter extends RecyclerView.Adapter<SkillsIqAdpter.skillsViewHolder> {
    private List<SkillsIqList>skillsIqlists;
    Context context;


    public SkillsIqAdpter(Context context, List<SkillsIqList> skillsIqLists) {
        this.skillsIqlists = skillsIqlists;
        this.context = this.context;
    }

    @NonNull
    @Override
    public skillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        skillsViewHolder skilsShow = new skillsViewHolder(v);
         return skilsShow;



    }

    public void setSkillsIqlists(List<SkillsIqList> lists) {
        this.skillsIqlists = lists;
    }

    @Override
    public void onBindViewHolder(@NonNull skillsViewHolder holder, int position) {
        SkillsIqList lists = skillsIqlists.get(position);
        holder.name.setText(lists.getName());
        holder.hours.setText(lists.getHours()+" learning hours, "+ lists.getCountry()+"");
        Picasso.get().load(lists.getBadgeUrl()).into(holder.budgeImage);


    }

    @Override
    public int getItemCount() {

        if (skillsIqlists != null){
            return skillsIqlists.size();
        }
        return 0;
    }


    public static class skillsViewHolder extends RecyclerView.ViewHolder{
        public ImageView budgeImage;
        public  TextView name;
        public TextView hours;
        public View root;

        public skillsViewHolder(@NonNull View itemView) {
            super(itemView);


            budgeImage = itemView.findViewById(R.id.budgeimage);
            name = itemView.findViewById(R.id.name);
            hours = itemView.findViewById(R.id.hours);
        }


}

}
