package com.example.lute.takeuappointment;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class BBMenuClienteActivity extends AppCompatActivity {

    //DECLARO ETIQUETAS IMAGEN, ADAPATADOR Y RECYCLERVIEW LIST
    ImageView foto;
    ArrayList<ZProfesional> listaEmpresas;
    RecyclerView recyclerEmpresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbmenu_cliente);
        
        //RELACIONO ETIQUETAS CON ELEMENTOS LAYOUT
        foto=(ImageView)findViewById(R.id.ivItemMenuClienteImagen);

        //MOSTRAR LISTA DE CLIENTES
        listaEmpresas = new ArrayList<>();
        recyclerEmpresas = (RecyclerView) findViewById(R.id.listBBMenuCliente);
        recyclerEmpresas.setLayoutManager(new LinearLayoutManager(this));

        datosEmpresa();

        ZAdaptadorEmpresas adapter  = new ZAdaptadorEmpresas(listaEmpresas);
        recyclerEmpresas.setAdapter(adapter);


    }
    //BOTON PROVISIONAL
    public void ClickLogin1(View view){
        Intent i = new Intent().setClass(getApplicationContext(), BALoginActivity.class);
        startActivity(i);
    }
    

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Uri path=data.getData();
            foto.setImageURI(path);
        }
    }

    private void datosEmpresa(){
        listaEmpresas.add (new ZProfesional("usuario","contraseña","nombre","empresa","descripcion","lugar","direccion",R.drawable.uj,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("Ricardo Corazón de León y Piel Roja de la Gaita","contraseña1","nombre1","Empresa de Harlekines S.A.Company Queen","Empresa de Halloween que abre en Enero, una locura xD","lugar","Calle Falsa 123456789",R.drawable.bc,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("Ricardo Corazón de León y Piel Roja de la Gaita","contraseña1","nombre1","Empresa de Harlekines S.A.Company Queen","Empresa de Halloween que abre en Enero, una locura xD","lugar","Calle Falsa 123456789",R.drawable.bc_grande,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("Ricardo Corazón de León y Piel Roja de la Gaita","contraseña1","nombre1","Empresa de Harlekines S.A.Company Queen (la novia del Joker)","Empresa de Halloween que abre en Enero, una locura xD que sale en la serie de Boujack Hourman","lugar","Calle Falsa 123456789, que más o menos cogido de los Simpsons",R.drawable.bc_grande,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("Ricardo Corazón de León y Piel Roja de la Gaita","contraseña1","nombre1","Empresa de Harlekine","Empresa de Halloween que abre en Eneroç","lugar","Calle Falsa",R.drawable.bc_grande,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("Ricardo Corazón de León y Piel Roja de la Gaita","contraseña1","nombre1","Empresa de Harlekines S.A.Company Queen","Empresa de Halloween que abre en Enero, una locura xD","lugar","Calle Falsa 123456789",R.drawable.bc_peque,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("usuario2","contraseña2","nombre2","ZAPATOS ZP","Zapatería","lugar","C/ Bajo duero 2",R.drawable.cb,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("usuario3","contraseña3","nombre3","ZAPATOS ZP","Zapatería","lugar","Jerez",R.drawable.cc,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
        listaEmpresas.add (new ZProfesional("usuario4","contraseña4","nombre4","empresa4","descripcion4","lugar","direccion4",R.drawable.hr,"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"));
    }

}