package com.example.lute.takeuappointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CCRegistroClienteActivity extends AppCompatActivity {

    EditText etCCRegistroDNI, etCCRegistroContrasena, etCCRegistroNombre, etCCRegistroApellidos, etCCRegistroEmail, etCCRegistroTelefono,
     etCCRegistroCiudad, etCCRegistroDireccion;

    Button btnCCRegistrarRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccregistro_cliente);

        etCCRegistroDNI = (EditText)findViewById(R.id.etCCRegistroDNI);
        etCCRegistroContrasena = (EditText)findViewById(R.id.etCCRegistroContrasena);
        etCCRegistroNombre = (EditText)findViewById(R.id.etCCRegistroNombre);
        etCCRegistroApellidos = (EditText)findViewById(R.id.etCCRegistroApellidos);
        etCCRegistroEmail = (EditText)findViewById(R.id.etCCRegistroEmail);
        etCCRegistroTelefono = (EditText)findViewById(R.id.etCCRegistroTelefono);
        etCCRegistroCiudad = (EditText)findViewById(R.id.etCCRegistroCiudad);
        etCCRegistroDireccion = (EditText)findViewById(R.id.etCCRegistroDireccion);

        btnCCRegistrarRegistrar= (Button)findViewById(R.id.btnCCRegistrarRegistrar);

    }
}
