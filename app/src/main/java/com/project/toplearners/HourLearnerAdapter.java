package com.project.toplearners;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HourLearnerAdapter extends RecyclerView.Adapter<TopLearnersViewHolder>{

    private List<HourLearner> mHourLearnerList;

    public HourLearnerAdapter(List<HourLearner> hourLearnerList){
        this.mHourLearnerList = hourLearnerList;
    }

    @NonNull
    @Override
    public TopLearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new TopLearnersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TopLearnersViewHolder holder, int position) {
        HourLearner cTopLearner = mHourLearnerList.get(position);

        String name = cTopLearner.getName();
        String hours = String.valueOf(cTopLearner.getHours());
        String country = cTopLearner.getCountry();
        String badgeUrl = cTopLearner.getBadgeUrl();
        holder.mLeaderName.setText(name);
        holder.mLearnerHours.setText(hours + " learning hours. " + country);
        Picasso.get().load(badgeUrl).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mHourLearnerList.size();
    }

}
