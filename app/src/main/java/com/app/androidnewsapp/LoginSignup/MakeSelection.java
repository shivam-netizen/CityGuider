package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class MakeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }

    public void callBackScreenFromMakeSelection(View view) {
       finish();
    }

    public void callOTPScreenFromMakeSelection(View view) {
        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
        startActivity(intent);

    }

    public void callMailVerifyScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
        startActivity(intent);

    }
}