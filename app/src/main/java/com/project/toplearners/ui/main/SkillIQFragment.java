package com.project.toplearners.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.toplearners.R;
import com.project.toplearners.RetrofitManager;
import com.project.toplearners.SkillIQAdapter;
import com.project.toplearners.SkillIQLearner;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQFragment extends Fragment {

    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        final View root = inflater.inflate(R.layout.fragment_iq, container, false);
        mRecyclerView = root.findViewById(R.id.skill_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        Call<List<SkillIQLearner>> call = RetrofitManager.skillCall;
        call.enqueue(new Callback<List<SkillIQLearner>>() {
            @Override
            public void onResponse(Call<List<SkillIQLearner>> call, Response<List<SkillIQLearner>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                List<SkillIQLearner> topLearners = response.body();

                mRecyclerView.setAdapter(new SkillIQAdapter(topLearners));

            }

            @Override
            public void onFailure(Call<List<SkillIQLearner>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
        return root;
    }
}
