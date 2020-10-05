package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.cityguide.R;

public class Signup3 extends AppCompatActivity {


    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup3);


        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);

//        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/ds_digib.TTF");
//        slideText.setTypeface(custom_font);


    }

    public void callVerifyOTPScreen(View view) {

            Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);



                startActivity(intent);


    }

    public void backToLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);



        startActivity(intent);
        finish();
    }

    public void callBackScreenFromSingup3(View view) {
        finish();
    }
}