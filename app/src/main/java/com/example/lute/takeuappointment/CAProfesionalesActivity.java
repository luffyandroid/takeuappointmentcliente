package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class CAProfesionalesActivity extends AppCompatActivity {

    ArrayList<ZCliente> listaClientes;
    RecyclerView recyclerClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caprofesionales);

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

    private void datosClientes(){
        listaClientes.add(new ZCliente("","","Melania","Gallego de los Santos","","17:30","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","",R.drawable.sailor));
    }

}
