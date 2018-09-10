package com.example.lute.takeuappointment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DAConfirmacionProfesionalesActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    TextView tvDAConfProfesionalesUsuario, tvDAConfProfesionalesNombre, tvDAConfProfesionalesApellidos, tvDAConfProfesionalesFecha, tvDAConfProfesionalesHora, tvDAConfProfesionalesLugar, tvDAConfProfesionalesDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daconfirmacion_profesionales);

        //TOAST COMPROBACIÓN SI HAY INTERNET
        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet", Toast.LENGTH_LONG)
                    .show();
        }

        //ENLAZO ELEMENTOS LAYOUT
        tvDAConfProfesionalesUsuario=(TextView)findViewById(R.id.tvDAConfProfesionalesUsuario);
        tvDAConfProfesionalesNombre=(TextView)findViewById(R.id.tvDAConfProfesionalesNombre);
        tvDAConfProfesionalesApellidos=(TextView)findViewById(R.id.tvDAConfProfesionalesApellidos);
        tvDAConfProfesionalesFecha=(TextView)findViewById(R.id.tvDAConfProfesionalesFecha);
        tvDAConfProfesionalesHora=(TextView)findViewById(R.id.tvDAConfProfesionalesHora);
        tvDAConfProfesionalesLugar=(TextView)findViewById(R.id.tvDAConfProfesionalesLugar);
        tvDAConfProfesionalesDireccion=(TextView)findViewById(R.id.tvDAConfProfesionalesDireccion);
    }

    //BOTON VOLVER ANTERIOR ACTIVITY
    public void ClickDAProfesionalesModificar(View view) {
       /*  Intent i = new Intent().setClass(getApplicationContext(), CBClienteActivity.class);
        startActivity(i);*/
    }

    //BOTON CANCELAR CITA
    public void ClickDAProfesionalesCancelar(View view) {
      /*  Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);*/
    }

    //BOTON VOLVER ACTIVITY MENU
    public void ClickDAProfesionalesConfirmar(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), CAProfesionalesActivity.class);
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
