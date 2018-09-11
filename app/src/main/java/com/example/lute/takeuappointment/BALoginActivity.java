package com.example.lute.takeuappointment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BALoginActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    EditText etBALoginDNI, etBALoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balogin);

        //TOAST COMPROBACIÓN SI HAY INTERNET
        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet", Toast.LENGTH_LONG)
                    .show();
        }

        //ENLAZO ELEMENTOS LAYOUT
        etBALoginDNI = (EditText) findViewById(R.id.etBALoginDNI);
        etBALoginPassword = (EditText) findViewById(R.id.etBALoginPassword);
    }

    //BOTONES PROVISIONALES
    public void clickProf1(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), CAProfesionalesActivity.class);
        startActivity(i);
    }

    public void clickCliente1(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), CBClienteActivity.class);
        startActivity(i);
    }

    public void clickCliente2(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), DAConfirmacionClienteActivity.class);
        startActivity(i);
    }

    public void clickProf2(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), DAConfirmacionProfesionalesActivity.class);
        startActivity(i);
    }

    //BOTON VOLVER ANTERIOR ACTIVITY
    public void ClickGoogle(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);
    }

    //COMPROBACIÓN CONEXIÓN INTERNET
    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;

    }
}
