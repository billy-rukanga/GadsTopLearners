package com.project.toplearners;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<TopLearnersViewHolder>{

    List<SkillIQLearner> mSkillIQLearners;

    public SkillIQAdapter(List<SkillIQLearner> learners){
        this.mSkillIQLearners = learners;
    }
    @NonNull
    @Override
    public TopLearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new TopLearnersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopLearnersViewHolder holder, int position) {
        SkillIQLearner cSillIQLearner = mSkillIQLearners.get(position);

        String name = cSillIQLearner.getName();
        String score = String.valueOf(cSillIQLearner.getScore());
        String country = cSillIQLearner.getCountry();
        String badgeUrl = cSillIQLearner.getBadgeUrl();
        holder.mLeaderName.setText(name);
        holder.mLearnerHours.setText(score + " skill IQ Score. " + country);
        Picasso.get().load(badgeUrl).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mSkillIQLearners.size();
    }
}
