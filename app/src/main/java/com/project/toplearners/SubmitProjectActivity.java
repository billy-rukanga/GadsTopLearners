package com.project.toplearners;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitProjectActivity extends AppCompatActivity {

    Dialog mSubmitDialog, mSuccessDialog, mFailureDialog;
    Button submit, dialogSubmit;
    ImageView cancel, back;
    EditText mFirstName, mLastName, mEmail, mLink;
    String email, firstName, lastName, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        mSuccessDialog = new Dialog(this);
        mFailureDialog = new Dialog(this);
        mSubmitDialog = new Dialog(this);
        submit = findViewById(R.id.form_submit_btn);
        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mEmail = findViewById(R.id.email);
        mLink = findViewById(R.id.github_link);
        back = findViewById(R.id.back_image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubmitProjectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("email cannot be empty");
                    return;
                }

                firstName = mFirstName.getText().toString();
                if(TextUtils.isEmpty(firstName)){
                    mEmail.setError("First name cannot be empty");
                    return;
                }
                lastName = mLastName.getText().toString();
                if(TextUtils.isEmpty(lastName)){
                    mEmail.setError("Last name cannot be empty");
                    return;
                }
                link = mLink.getText().toString();
                if(TextUtils.isEmpty(link)){
                    mEmail.setError("Please enter a link");
                    return;
                }

                mSubmitDialog.setContentView(R.layout.confirm_dialog);
                cancel = mSubmitDialog.findViewById(R.id.cancel_submission_img);
                dialogSubmit = mSubmitDialog.findViewById(R.id.dialog_submit_btn);

                dialogSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        submit();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSubmitDialog.dismiss();
                    }
                });
                mSubmitDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                mSubmitDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mSubmitDialog.show();

            }
        });
    }

    private void submit() {
        Call<SubmitModel> submitModelCall = RetrofitManager.sLearnerJsonApi.submitProject(email, firstName, lastName, link);
        submitModelCall.enqueue(new Callback<SubmitModel>() {
            @Override
            public void onResponse(Call<SubmitModel> call, Response<SubmitModel> response) {

                if(response.isSuccessful()) {

                    mSuccessDialog.setContentView(R.layout.submission_successful_dialog);

                    mSuccessDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    mSuccessDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    mSuccessDialog.show();
                    mSubmitDialog.dismiss();
                }else{
                    failure();
                }
            }

            @Override
            public void onFailure(Call<SubmitModel> call, Throwable t) {

                Log.d("Billy error", t.getMessage());
                failure();

            }

            private void failure() {

                mFailureDialog.setContentView(R.layout.submission_failed_dialog);

                mFailureDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                mFailureDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mFailureDialog.show();

                mSubmitDialog.dismiss();
            }
        });
    }
}