package com.project.toplearners;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopLearnersViewHolder extends RecyclerView.ViewHolder{

    public ImageView mImageView;
    public TextView mLeaderName;
    public TextView mLearnerHours;

    public TopLearnersViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView);
        mLeaderName = itemView.findViewById(R.id.learner_name);
        mLearnerHours = itemView.findViewById(R.id.learner_hours);
    }
}
