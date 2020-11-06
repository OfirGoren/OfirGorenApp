package com.example.ofirgorenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.ofirgorenapp.Activity_Sign.EXTRA_FIRST_NAME_ID;
import static com.example.ofirgorenapp.Activity_Sign.EXTRA_LAST_NAME_ID;
import static com.example.ofirgorenapp.Activity_Sign.EXTRA_PASSWORD_ID;

public class Activity_Connect extends AppCompatActivity {

    private TextView connect_LBL_first_name;
    private TextView connect_LBL_last_name;
    private TextView connect_LBL_password;
    private TextView connect_BTN_close;
    private Intent intent;
    private String firstName;
    private String lastName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conncet);


        allFindViewById();

        getStringExtra();

        setDetailsContact();

        clickButtonListener();

    }

    private void allFindViewById() {
        connect_BTN_close = findViewById(R.id.connect_BTN_close);
        connect_LBL_first_name = findViewById(R.id.connect_LBL_first_name);
        connect_LBL_last_name = findViewById(R.id.connect_LBL_last_name);
        connect_LBL_password = findViewById(R.id.connect__LBL_password);
    }

    private void clickButtonListener() {
        connect_BTN_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainActivity();
            }
        });
    }

    private void getStringExtra() {
        intent = getIntent();
        firstName = intent.getStringExtra(EXTRA_FIRST_NAME_ID);
        lastName = intent.getStringExtra(EXTRA_LAST_NAME_ID);
        password = intent.getStringExtra(EXTRA_PASSWORD_ID);
    }

    private void backToMainActivity() {
        Intent intentReturn = new Intent(this, MainActivity.class);
        intentReturn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentReturn);
        finish();
    }


    private void setDetailsContact() {

        connect_LBL_first_name.setText(firstName);
        connect_LBL_last_name.setText(lastName);
        connect_LBL_password.setText(password);
    }
}