package com.example.lute.takeuappointment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BALoginActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    EditText etBALoginDNI, etBALoginPassword;
    Spinner spBALogin;
    Switch swBALogin;
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;
    static final String EXTRA_USUARIO = "USUARIO";

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
        spBALogin = (Spinner)findViewById(R.id.spBALogin);
        swBALogin = (Switch)findViewById(R.id.swBALogin);
        swBALogin.setChecked(false);
        swBALogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    swBALogin.setText("Login profesional");
                }else{
                    swBALogin.setText("Login cliente");
                }
            }
        });
        String[] empresas = {"prueba", "prueba empresa guay", "pruebetic"};
        spBALogin.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, empresas));
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

    public void clickInicio(View view) {

        String usuario = etBALoginDNI.getText().toString();
        final String contrasena = etBALoginPassword.getText().toString();
        final String empresaElegida = spBALogin.getSelectedItem().toString();
        /*if (swBALogin.isChecked()) {
            dbRef = FirebaseDatabase.getInstance().getReference().child(empresaElegida + "/profesionales/" + usuario);
            Toast.makeText(getApplicationContext(), "Elige profesional", Toast.LENGTH_SHORT).show();
        }else{*/
            dbRef = FirebaseDatabase.getInstance().getReference().child(empresaElegida + "/clientes/" + usuario);
            Toast.makeText(getApplicationContext(), "Elige cliente", Toast.LENGTH_SHORT).show();
        //}

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getValue() == null) {
                    // tvFalloLogin.setText("El usuario no existe");
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                } else {


                    ZCliente usu = dataSnapshot.getValue(ZCliente.class);

                    String contrasenadb = usu.getCcontrasena();

                    if (!contrasena.equals(contrasenadb)) {
                        // tvFalloLogin.setText("La contraseña no coincide");
                        Toast.makeText(getApplicationContext(), "Password incorrecto", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent mainIntent = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
                        mainIntent.putExtra(EXTRA_USUARIO, usu);
                        startActivity(mainIntent);
                        finish();

                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("LoginActivity", "DATABASE ERROR");
            }
        };
        dbRef.addValueEventListener(valueEventListener);


    }

}
