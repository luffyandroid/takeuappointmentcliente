package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CCRegistroClienteActivity extends AppCompatActivity {

    EditText etCCRegistroDNI, etCCRegistroContrasena, etCCRegistroContrasena2, etCCRegistroNombre, etCCRegistroApellidos, etCCRegistroEmail, etCCRegistroTelefono,
     etCCRegistroCiudad, etCCRegistroDireccion;

    Button btnCCRegistrarRegistrar;

    Switch swchCCRegistroCambio;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccregistro_cliente);

        etCCRegistroDNI = (EditText)findViewById(R.id.etCCRegistroDNI);
        etCCRegistroContrasena = (EditText)findViewById(R.id.etCCRegistroContrasena);
        etCCRegistroContrasena2 = (EditText)findViewById(R.id.etCCRegistroContrasena2);
        etCCRegistroNombre = (EditText)findViewById(R.id.etCCRegistroNombre);
        etCCRegistroApellidos = (EditText)findViewById(R.id.etCCRegistroApellidos);
        etCCRegistroEmail = (EditText)findViewById(R.id.etCCRegistroEmail);
        etCCRegistroTelefono = (EditText)findViewById(R.id.etCCRegistroTelefono);
        etCCRegistroCiudad = (EditText)findViewById(R.id.etCCRegistroCiudad);
        etCCRegistroDireccion = (EditText)findViewById(R.id.etCCRegistroDireccion);

        btnCCRegistrarRegistrar= (Button)findViewById(R.id.btnCCRegistrarRegistrar);

        swchCCRegistroCambio= (Switch)findViewById(R.id.swchCCRegistroCambio);

    }

    public void clickRegistrar(View view){

        String dni = etCCRegistroDNI.getText().toString();
        String contrasena = etCCRegistroContrasena.getText().toString();
        String contrasena2 = etCCRegistroContrasena2.getText().toString();
        String nombre = etCCRegistroNombre.getText().toString();
        String apellidos = etCCRegistroApellidos.getText().toString();
        String email = etCCRegistroEmail.getText().toString();
        String telefono = etCCRegistroTelefono.getText().toString();
        String ciudad = etCCRegistroCiudad.getText().toString();
        String direccion = etCCRegistroDireccion.getText().toString();
        String fecha = "";
        String hora = "";
        String lugar = "";
        String profesional = "";
        int foto = 1;
        String p1 = "p1";
        String p2 = "p2";
        String p3 = "p3";
        String p4 = "p4";
        String p5 = "p5";
        String p6 = "p6";
        String p7 = "p7";
        String p8 = "p8";
        String p9 = "p9";

        if (dni.equals("") || contrasena.equals("") || contrasena2.equals("") || nombre.equals("") || apellidos.equals("") ||
                email.equals("") || telefono.equals("") || ciudad.equals("") || direccion.equals("")){

            Toast.makeText(getApplicationContext(),"Debes rellenar todos los dator",Toast.LENGTH_LONG).show();

        }else{
            if (!contrasena.equals(contrasena2)){
                Toast.makeText(getApplicationContext(),"Las contraseñas deben ser iguales",Toast.LENGTH_LONG).show();
            }else{
                if (swchCCRegistroCambio.isChecked()){

                    ZProfesional nuevoProfesional=new ZProfesional(dni, contrasena, nombre, apellidos, email, telefono, ciudad, direccion, foto, p1, p2, p3, p4, p5, p6, p7, p8, p9);
                    dbRef = FirebaseDatabase.getInstance().getReference().child(email+"/profesionales");
                    dbRef.child(nombre).setValue(nuevoProfesional, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null){

                                Toast.makeText(getApplicationContext(),"Profesional insertado correctamente",Toast.LENGTH_LONG).show();


                            }else{

                                Toast.makeText(getApplicationContext(),"No se puede insertar el profesional",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                    /*Intent mainIntent = new Intent().setClass(getApplicationContext(), LoginActivity.class);
                    startActivity(mainIntent);
                    finish();*/



                }else{
                    ZCliente nuevoCliente=new ZCliente(dni, contrasena, nombre, apellidos, email, telefono, fecha, hora, lugar, ciudad, direccion, profesional, p1, p2, p3, p4, p5, p6, foto);
                    dbRef = FirebaseDatabase.getInstance().getReference().child(email+"/clientes");
                    dbRef.child(nombre).setValue(nuevoCliente, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null){

                                Toast.makeText(getApplicationContext(),"Cliente insertado correctamente",Toast.LENGTH_LONG).show();


                            }else{

                                Toast.makeText(getApplicationContext(),"No se puede insertar el Cliente",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        }


    }

}
