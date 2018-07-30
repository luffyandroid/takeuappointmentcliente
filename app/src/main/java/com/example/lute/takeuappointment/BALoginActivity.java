package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BALoginActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    EditText etBALoginDNI, etBALoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balogin);

        //ENLAZO ELEMENTOS LAYOUT
        etBALoginDNI=(EditText)findViewById(R.id.etBALoginDNI);
        etBALoginPassword=(EditText)findViewById(R.id.etBALoginPassword);
    }

    //BOTONES PROVISIONALES
    public void clickProf1(View view){
        Intent i = new Intent().setClass(getApplicationContext(), CAProfesionalesActivity.class);
        startActivity(i);
    }
    public void clickCliente1(View view){
        Intent i = new Intent().setClass(getApplicationContext(), CBClienteActivity.class);
        startActivity(i);
    }
    public void clickCliente2(View view){
        Intent i = new Intent().setClass(getApplicationContext(), DAConfirmacionClienteActivity.class);
        startActivity(i);
    }
    public void clickProf2(View view){
        Intent i = new Intent().setClass(getApplicationContext(), DAConfirmacionProfesionalesActivity.class);
        startActivity(i);
    }

    //BOTON VOLVER ANTERIOR ACTIVITY
    public void ClickGoogle(View view) {
       Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);
    }

}
