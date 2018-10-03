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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DAConfirmacionClienteActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    TextView tvDAConfClienteUsuario, tvDAConfClienteNombre, tvDAConfClienteApellidos, tvDAConfClienteFecha, tvDAConfClienteHora, tvDAConfClienteLugar, tvDAConfClienteDireccion;

    String fecha, hora, direccion;

    static final String EXTRA_FECHA = "FECHA";
    static final String EXTRA_HORA = "HORA";
    static final String EXTRA_DIRECCION = "DIRECCION";
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

        Bundle b = getIntent().getExtras();
        if (b!=null){
            tvDAConfClienteFecha.setText(getIntent().getExtras().getString(EXTRA_FECHA));
            tvDAConfClienteHora.setText(getIntent().getExtras().getString(EXTRA_HORA));
            tvDAConfClienteDireccion.setText(getIntent().getExtras().getString(EXTRA_DIRECCION));
        }

    }



    //BOTON VOLVER ANTERIOR ACTIVITY
    public void ClickDAClientesModificar(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), CBClienteActivity.class);
        i.putExtra(EXTRA_FECHA, tvDAConfClienteFecha.getText().toString());
        i.putExtra(EXTRA_HORA, tvDAConfClienteHora.getText().toString());
        i.putExtra(EXTRA_DIRECCION, tvDAConfClienteDireccion.getText().toString());
        startActivity(i);
    }

    //BOTON CANCELAR CITA
    public void ClickDAClientesCancelar(View view) {
      /*  Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);*/
    }

    //BOTON VOLVER ACTIVITY MENU
    public void ClickDAClientesConfirmar(View view) {

        //DECLARAR LOS RESTANTES DATOS DE LA CLASE ZUSUARIO
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        final String uidf = "luis";
        String fechaf = tvDAConfClienteFecha.getText().toString();
        String horaf = tvDAConfClienteHora.getText().toString();
        String direccionf = tvDAConfClienteDireccion.getText().toString();
        String lugarf = tvDAConfClienteLugar.getText().toString();


        //SUBIR DATOS AL FIREBASE
        DatabaseReference dbRef =
                FirebaseDatabase.getInstance().getReference()
                        .child("pruebetic").child("clientes");

        Map<String, Object> actualizacion = new HashMap<>();
        actualizacion.put("/cfecha", fechaf);
        actualizacion.put("/chora", horaf);
        actualizacion.put("/cdireccion", direccionf);
        actualizacion.put("/clugar", lugarf);

        dbRef.child(uidf)
                .updateChildren(actualizacion);

        {
            if (user != null) {

            }


        }

        Toast.makeText(this, "Subido", Toast.LENGTH_SHORT).show();
        /*Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);*/
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
