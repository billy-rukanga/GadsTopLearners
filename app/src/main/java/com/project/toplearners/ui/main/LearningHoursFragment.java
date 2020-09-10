package com.project.toplearners.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.toplearners.MainActivity;
import com.project.toplearners.R;
import com.project.toplearners.HourLearner;
import com.project.toplearners.HourLearnerAdapter;

import java.util.List;

public class LearningHoursFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        Intent intent = activity.getIntent();
        List<HourLearner> topLearners = intent.getParcelableArrayListExtra("bundle");
        View root = inflater.inflate(R.layout.fragment_learner, container, false);
        mRecyclerView = root.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        mRecyclerView.setAdapter(new HourLearnerAdapter(topLearners));
        return root;
    }


}