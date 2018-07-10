package com.example.lute.takeuappointment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class AASplashActivity extends AppCompatActivity {

    //TIEMPO PARA EL SPLASH
    private static final long SPLASH_SCREEN_DELAY = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_aasplash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //TERMINAR SPLASH E IR A SIGUIENTE ACTIVITY
                Intent mainIntent = new Intent().setClass(
                        AASplashActivity.this, BALoginActivity.class);
                startActivity(mainIntent);

                //ELIMINAR
                finish();

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}