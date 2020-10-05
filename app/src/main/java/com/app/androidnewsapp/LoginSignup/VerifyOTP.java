package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
    }

    public void goToHomeFromOTP(View view) {
        finish();
    }

    public void callNextScreenFromOTP(View view) {
        Intent intent = new Intent(getApplicationContext(), SetNewPassword.class);
        startActivity(intent);

    }
}