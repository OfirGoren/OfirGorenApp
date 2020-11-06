package com.example.ofirgorenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button main_BTN_sign_in;
    Animation zoomInBtn;
    Animation zoomOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        allFindViewById();

        zoomInAnimation();

        zoomInListener();

        signInButtonClickCheck();


    }

    private void allFindViewById() {
        main_BTN_sign_in = findViewById(R.id.main_BTN_sign_in);
    }

    private void signInButtonClickCheck() {
        main_BTN_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivitySignIn();
            }
        });
    }

    private void zoomOutListener() {
        zoomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                main_BTN_sign_in.startAnimation(zoomInBtn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    private void zoomInListener() {
        zoomInBtn.setAnimationListener(new Animation.AnimationListener() {


            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                zoomOutAnimation();
                zoomOutListener();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    private void zoomOutAnimation() {
        zoomOut = AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.zoom_out);
        main_BTN_sign_in.startAnimation(zoomOut);
    }

    private void zoomInAnimation() {

        zoomInBtn = AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.zoom_in);
        main_BTN_sign_in.startAnimation(zoomInBtn);


    }


    private void openNewActivitySignIn() {
        Intent signInIntent = new Intent(this, Activity_Sign.class);
        this.startActivity(signInIntent);
        finish();
    }
}