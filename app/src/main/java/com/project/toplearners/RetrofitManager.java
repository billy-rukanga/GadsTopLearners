package com.project.toplearners;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gadsapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
    private static LearnerJsonApi learnerJsonApi = retrofit.create(LearnerJsonApi.class);

    private static Retrofit sRetrofitManager = new Retrofit.Builder().baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public static LearnerJsonApi sLearnerJsonApi = sRetrofitManager.create(LearnerJsonApi.class);

    public static Call<List<HourLearner>> call = learnerJsonApi.getInfo();
    public static Call<List<SkillIQLearner>> skillCall = learnerJsonApi.getSkilliq();

}
