package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DAConfirmacionClienteActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    TextView tvDAConfClienteUsuario, tvDAConfClienteNombre, tvDAConfClienteApellidos, tvDAConfClienteFecha, tvDAConfClienteHora, tvDAConfClienteLugar, tvDAConfClienteDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daconfirmacion_cliente);

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

}
