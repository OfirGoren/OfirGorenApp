package com.example.ofirgorenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_Sign extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_FIRST_NAME_ID = "EXTRA_FIRST_NAME_ID";
    public static final String EXTRA_LAST_NAME_ID = "EXTRA_LAST_NAME_ID";
    public static final String EXTRA_PASSWORD_ID = "EXTRA_PASSWORD_ID";
    Button sign_BTN_clear_first_name;
    Button sign_BTN_clear_last_name;
    Button sign_BTN_clear_email;
    Button sign_BTN_connect;
    EditText sign_EDT_add_first_name;
    EditText sign_EDT_add_last_name;
    EditText sign_EDT_add_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sign);

        allFindViewById();

        checkClickButtons();


    }

    private void allFindViewById() {
        sign_BTN_clear_first_name = findViewById(R.id.sign_BTN_clear_first_name);
        sign_BTN_clear_last_name = findViewById(R.id.sign_BTN_clear_last_name);
        sign_BTN_clear_email = findViewById(R.id.sign_BTN_clear_email);
        sign_BTN_connect = findViewById(R.id.sign_BTN_connect);
        sign_EDT_add_first_name = findViewById(R.id.sign_EDT_add_first_name);
        sign_EDT_add_last_name = findViewById(R.id.sign_EDT_add_last_name);
        sign_EDT_add_email = findViewById(R.id.sign_EDT_add_password);
    }


    private void checkClickButtons() {

        sign_BTN_clear_first_name.setOnClickListener(this);
        sign_BTN_clear_last_name.setOnClickListener(this);
        sign_BTN_clear_email.setOnClickListener(this);
        sign_BTN_connect.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_BTN_clear_first_name:
                sign_EDT_add_first_name.setText("");
                break;
            case R.id.sign_BTN_clear_last_name:
                sign_EDT_add_last_name.setText("");
                break;
            case R.id.sign_BTN_clear_email:
                sign_EDT_add_email.setText("");
                break;
            case R.id.sign_BTN_connect:
                Intent intent = new Intent(this, Activity_Connect.class);
                intent.putExtra(EXTRA_FIRST_NAME_ID, sign_EDT_add_first_name.getText().toString());
                intent.putExtra(EXTRA_LAST_NAME_ID, sign_EDT_add_last_name.getText().toString());
                intent.putExtra(EXTRA_PASSWORD_ID, sign_EDT_add_email.getText().toString());
                this.startActivity(intent);
                finish();
                break;

        }
    }
}