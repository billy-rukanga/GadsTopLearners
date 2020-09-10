package com.project.toplearners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Call<List<HourLearner>> mCall = RetrofitManager.call;
        mCall.clone().enqueue(new Callback<List<HourLearner>>() {
            @Override
            public void onResponse(Call<List<HourLearner>> call, Response<List<HourLearner>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                List<HourLearner> topLearners = response.body();
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                intent.putParcelableArrayListExtra("bundle", (ArrayList<? extends Parcelable>) topLearners);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<HourLearner>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();
        finish();
    } 

}