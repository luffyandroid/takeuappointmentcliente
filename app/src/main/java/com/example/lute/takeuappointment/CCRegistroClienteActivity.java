package com.example.lute.takeuappointment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CCRegistroClienteActivity extends AppCompatActivity {

    EditText etCCRegistroDNI, etCCRegistroContrasena, etCCRegistroContrasena2, etCCRegistroNombre, etCCRegistroApellidos, etCCRegistroEmail, etCCRegistroTelefono,
     etCCRegistroCiudad, etCCRegistroDireccion, etCCRegistroEmpresa, etCCRegistroDescripcion, etCCRegistroLugar;

    TextView tvCCRegistroFoto;

    Button btnCCRegistrarRegistrar;

    Switch swchCCRegistroCambio;

    String foto;

    ImageView ivCCRegistroFoto;

    DatabaseReference dbRef;
    StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccregistro_cliente);

        mStorage = FirebaseStorage.getInstance().getReference();

        etCCRegistroDNI = (EditText)findViewById(R.id.etCCRegistroDNI);
        etCCRegistroContrasena = (EditText)findViewById(R.id.etCCRegistroContrasena);
        etCCRegistroContrasena2 = (EditText)findViewById(R.id.etCCRegistroContrasena2);
        etCCRegistroNombre = (EditText)findViewById(R.id.etCCRegistroNombre);
        etCCRegistroApellidos = (EditText)findViewById(R.id.etCCRegistroApellidos);
        etCCRegistroEmail = (EditText)findViewById(R.id.etCCRegistroEmail);
        etCCRegistroTelefono = (EditText)findViewById(R.id.etCCRegistroTelefono);
        etCCRegistroCiudad = (EditText)findViewById(R.id.etCCRegistroCiudad);
        etCCRegistroDireccion = (EditText)findViewById(R.id.etCCRegistroDireccion);
        etCCRegistroEmpresa = (EditText)findViewById(R.id.etCCRegistroEmpresa);
        etCCRegistroDescripcion = (EditText)findViewById(R.id.etCCRegistroDescripcion);
        etCCRegistroLugar = (EditText)findViewById(R.id.etCCRegistroLugar);

        tvCCRegistroFoto = (TextView)findViewById(R.id.tvCCRegistroFoto);

        btnCCRegistrarRegistrar= (Button)findViewById(R.id.btnCCRegistrarRegistrar);

        swchCCRegistroCambio= (Switch)findViewById(R.id.swchCCRegistroCambio);

        ivCCRegistroFoto = (ImageView)findViewById(R.id.ivCCRegistroFoto);

        //Metodo para cambiar el registro para registrar clientes o registrar profesionales▼
        swchCCRegistroCambio.setChecked(false);
        swchCCRegistroCambio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    etCCRegistroEmail.setVisibility(View.GONE);
                    etCCRegistroTelefono.setVisibility(View.GONE);
                    etCCRegistroCiudad.setVisibility(View.GONE);
                    etCCRegistroEmpresa.setVisibility(View.VISIBLE);
                    etCCRegistroDescripcion.setVisibility(View.VISIBLE);
                    etCCRegistroLugar.setVisibility(View.VISIBLE);
                    btnCCRegistrarRegistrar.setText("Registrar profesional");
                } else {
                    etCCRegistroEmail.setVisibility(View.VISIBLE);
                    etCCRegistroTelefono.setVisibility(View.VISIBLE);
                    etCCRegistroCiudad.setVisibility(View.VISIBLE);
                    etCCRegistroEmpresa.setVisibility(View.GONE);
                    etCCRegistroDescripcion.setVisibility(View.GONE);
                    etCCRegistroLugar.setVisibility(View.GONE);
                    btnCCRegistrarRegistrar.setText("Registrar cliente");
                }
            }
        });
        //▲



    }

    //BOTON CARGAR IMAGEN▼

    public void ClickImagenRegistro(View view)
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 0);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photoViewer.setImageBitmap(imageBitmap);

            }*/
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        ivCCRegistroFoto.setImageBitmap(bitmap);
        //PROTOCOLO FECHA
        Date d=new Date();
        SimpleDateFormat fecc=new SimpleDateFormat("dMMMMyyyy");
        String fechacComplString = fecc.format(d);
        tvCCRegistroFoto.setText(etCCRegistroNombre.getText().toString()+etCCRegistroApellidos.getText().toString()+fechacComplString+".jpg");
    }

    private void subirFoto() {
        StorageReference storageRef = mStorage.child("images/"+tvCCRegistroFoto.getText().toString());
        ivCCRegistroFoto.setDrawingCacheEnabled(true);
        ivCCRegistroFoto.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) ivCCRegistroFoto.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = storageRef.putBytes(data);
        /*uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getApplicationContext(),"No se subio la imagen",Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(),"Se subio la imagen con éxito",Toast.LENGTH_LONG).show();
            }
        });*/

    }
    //FIN BOTON CARGAR IMAGEN▲

    //Click para registrar cleintes y profesionales▼
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
        String empresa = etCCRegistroEmpresa.getText().toString();
        String descripcion = etCCRegistroEmpresa.getText().toString();
        String lugar = etCCRegistroEmpresa.getText().toString();
        String fecha = "";
        String hora = "";
        String lugarcliente = "";
        String profesional = "";
        String foto = tvCCRegistroFoto.getText().toString();
        String p1 = "p1";
        String p2 = "p2";
        String p3 = "p3";
        String p4 = "p4";
        String p5 = "p5";
        String p6 = "p6";
        String p7 = "p7";
        String p8 = "p8";
        String p9 = "p9";

        if ((dni.equals("") || contrasena.equals("") || contrasena2.equals("") || nombre.equals("") || apellidos.equals("") ||
                email.equals("") || telefono.equals("") || ciudad.equals("") || direccion.equals("")) &&
                (dni.equals("") || contrasena.equals("") || contrasena2.equals("") || nombre.equals("") || apellidos.equals("") ||
                        empresa.equals("") || descripcion.equals("") || lugar.equals("") || direccion.equals("")) ){

            Toast.makeText(getApplicationContext(),"Debes rellenar todos los dator",Toast.LENGTH_LONG).show();

        }else{
            if (!contrasena.equals(contrasena2)){
                Toast.makeText(getApplicationContext(),"Las contraseñas deben ser iguales",Toast.LENGTH_LONG).show();
            }else{
                if (swchCCRegistroCambio.isChecked()){
                    subirFoto();
                    ZProfesional nuevoProfesional=new ZProfesional(dni, contrasena, nombre, apellidos, empresa, descripcion, lugar, direccion, foto, p1, p2, p3, p4, p5, p6, p7, p8, p9);
                    dbRef = FirebaseDatabase.getInstance().getReference().child(empresa+"/profesionales");
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
                    subirFoto();
                    ZCliente nuevoCliente=new ZCliente(dni, contrasena, nombre, apellidos, email, telefono, fecha, hora, lugarcliente, ciudad, direccion, profesional, p1, p2, p3, p4, p5, p6, foto);
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
    //▲

}
