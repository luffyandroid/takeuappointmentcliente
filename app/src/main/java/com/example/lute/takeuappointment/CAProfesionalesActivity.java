package com.example.lute.takeuappointment;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class CAProfesionalesActivity extends AppCompatActivity {

    ImageView foto;
    ArrayList<ZCliente> listaClientes;
    RecyclerView recyclerClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caprofesionales);

        foto=(ImageView)findViewById(R.id.ivItemProfImagen);

        //MOSTRAR LISTA DE CLIENTES
        listaClientes = new ArrayList<>();
        recyclerClientes = (RecyclerView) findViewById(R.id.rvProfesionales);
        recyclerClientes.setLayoutManager(new LinearLayoutManager(this));

        datosClientes();

        ZAdaptadorProfesionales adapter  = new ZAdaptadorProfesionales(listaClientes);
        recyclerClientes.setAdapter(adapter);
    }

    //BOTON PROVISIONAL
    public void ClickLogin1(View view){
        Intent i = new Intent().setClass(getApplicationContext(), BALoginActivity.class);
        startActivity(i);
    }

    //BOTON CARGAR IMAGEN
    public void ClickImagen (View view){
        cargarImagen();
    }

    private void cargarImagen(){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/");
        startActivityForResult(i.createChooser(i,"Seleccione la Aplicación"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Uri path=data.getData();
            foto.setImageURI(path);
        }
    }

    private void datosClientes(){
        listaClientes.add(new ZCliente("","","Melania Gallego de los Santos","","17:30","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","",R.drawable.imagen_no_disponible));
    }

}
