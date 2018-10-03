package com.example.lute.takeuappointment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CBHorasDialog extends AppCompatActivity {

    ArrayList<ZCliente> listaHoras = new ArrayList<ZCliente>();
    ListView listCBHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_cb_horas);
    }

    /*private void datosClientes(){
        listaClientes.add();
        listaClientes.add();
        listaClientes.add();
        listaClientes.add();
        listaClientes.add();
        listaClientes.add();
        listaClientes.add();
        listaClientes.add();
    }*/

}
