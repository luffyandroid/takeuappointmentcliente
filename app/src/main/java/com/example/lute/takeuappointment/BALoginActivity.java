package com.example.lute.takeuappointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
