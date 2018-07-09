package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DAConfirmacionProfesionalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daconfirmacion_profesionales);
    }
    public void ClickLogin4(View view){
        Intent i = new Intent().setClass(getApplicationContext(), BALoginActivity.class);
        startActivity(i);
    }

}
