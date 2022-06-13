package com.rku_21soeca21002.exampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ApiIntegration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_integration);





    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        ((Activity)this).finish();

    }

}