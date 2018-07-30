package com.example.lute.takeuappointment;

import android.content.Intent;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.time.Year;
import java.util.Calendar;

public class CBClienteActivity extends AppCompatActivity {

    //DECLARO INT VARIABLES CALENDARIO

    Button btnCBClienteFecha, btnCBClienteHora, btnCBClienteDireccion;
    TextView etCBClienteFecha, etCBClienteHora;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbcliente);

        //ENLAZO ELEMENTOS LAYOUT
        btnCBClienteFecha = findViewById(R.id.btnCBClienteFecha);
        etCBClienteFecha = findViewById(R.id.etCBClienteFecha);
        btnCBClienteHora = findViewById(R.id.btnCBClienteHora);
        etCBClienteHora = findViewById(R.id.etCBClienteHora);

        //BOTÓN CLICK EN DIRECCIONES
        btnCBClienteDireccion = findViewById(R.id.btnCBClienteDireccion);
        btnCBClienteDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog d = new Dialog(CBClienteActivity.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);
                d.setContentView(R.layout.dialog_cb_direcciones);
                d.show();

                TextView cabecera = d.findViewById(R.id.tvDialogCBCabecera);
                TextView titulo = d.findViewById(R.id.tvDialogCBTitulo);
                ListView direcciones = d.findViewById(R.id.listDialogCBDirecciones);

            }
        }); //0?

        //BOTÓN CLICK FECHA
        btnCBClienteFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OBTENER FECHA ACTUAL
                calendar = Calendar.getInstance();

                //AÑADIR ELEMENTOS QUE RECOGERA EL CALENDARIO
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                //ACTIVAR EL CALENDARIO
                datePickerDialog = new DatePickerDialog(CBClienteActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            //METODO PARA MOSTRAR FECHA TV
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                etCBClienteFecha.setText(day + "/" + (month + 1) + "/" + year); // +1 PORQUE EL MES DA -1
                            }
                        }, year, month, dayOfMonth);

                //ABRIR Y MOSTRAR DIALOGO
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }

    //BOTON VOLVER ANTERIOR ACTIVITY
    public void clickCBClienteVolverEmpresas(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);
    }

    //BOTON VOLVER SIGUIENTE ACTIVITY
    public void clickCBClienteSeguirCita(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), DAConfirmacionClienteActivity.class);
        startActivity(i);
    }

}


/*
    //BOTON DIALOGO HORA
    public void clickCBClienteHora(View view){

        //PREPAR EL DIALOGO
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //TITULO DEL DIALOGO
        builder.setTitle("Selecciona una hora");
    }
    */





