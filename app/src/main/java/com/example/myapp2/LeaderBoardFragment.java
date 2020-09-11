package com.example.myapp2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderBoardFragment extends Fragment {
    private RecyclerView mSkillsview;
    private RecyclerView.LayoutManager mSkillsviewManager;
    private RecyclerView.Adapter mSkillsviewAdpter;
    private List<LeaderList> leaderLists;
    private ApiInterface apiInterface;
    private LeaderAdpter adapter;
    private Context context;
    private ProgressDialog pd;

    public LeaderBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills_iq, container, false);
        mSkillsview = (RecyclerView) view.findViewById(R.id.recyclerview);




        mSkillsviewManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);



        adapter = new LeaderAdpter(getContext(),leaderLists);
        ArrayList<Object> leaderlist = new ArrayList<>();
        onload();

        return view;
    }

    private void onload() {
        apiInterface=RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<List<LeaderList>> call=apiInterface.getlearnersdata();
        call.enqueue(new Callback<List<LeaderList>>() {
            @Override
            public void onResponse(Call<List<LeaderList>> call, Response<List<LeaderList>> response) {
                leaderLists = response.body();
                adapter = new LeaderAdpter(getContext(), leaderLists);
                mSkillsview.setHasFixedSize(true);
                mSkillsview.setAdapter(adapter);

                mSkillsview.setLayoutManager(mSkillsviewManager);


            }

            @Override
            public void onFailure(Call<List<LeaderList>> call, Throwable t) {

            }


        });



    }
}