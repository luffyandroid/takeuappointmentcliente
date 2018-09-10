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

public class DAConfirmacionClienteActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    TextView tvDAConfClienteUsuario, tvDAConfClienteNombre, tvDAConfClienteApellidos, tvDAConfClienteFecha, tvDAConfClienteHora, tvDAConfClienteLugar, tvDAConfClienteDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daconfirmacion_cliente);

        //TOAST COMPROBACIÓN SI HAY INTERNET
        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet", Toast.LENGTH_LONG)
                    .show();
        }

        //ENLAZO ELEMENTOS LAYOUT
        tvDAConfClienteUsuario=(TextView)findViewById(R.id.tvDAConfClienteUsuario);
        tvDAConfClienteNombre=(TextView)findViewById(R.id.tvDAConfClienteNombre);
        tvDAConfClienteApellidos=(TextView)findViewById(R.id.tvDAConfClienteApellidos);
        tvDAConfClienteFecha=(TextView)findViewById(R.id.tvDAConfClienteFecha);
        tvDAConfClienteHora=(TextView)findViewById(R.id.tvDAConfClienteHora);
        tvDAConfClienteLugar=(TextView)findViewById(R.id.tvDAConfClienteLugar);
        tvDAConfClienteDireccion=(TextView)findViewById(R.id.tvDAConfClienteDireccion);
    }

    //BOTON VOLVER ANTERIOR ACTIVITY
    public void ClickDAClientesModificar(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), CBClienteActivity.class);
        startActivity(i);
    }

    //BOTON CANCELAR CITA
    public void ClickDAClientesCancelar(View view) {
      /*  Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);*/
    }

    //BOTON VOLVER ACTIVITY MENU
    public void ClickDAClientesConfirmar(View view) {
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
