package com.example.lute.takeuappointment;

import android.content.Context;
import android.content.Intent;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

public class CBClienteActivity extends AppCompatActivity {

    //DECLARO INT VARIABLES CALENDARIO

    Button btnCBClienteFecha, btnCBClienteHora, btnCBClienteDireccion;
    TextView etCBClienteFecha, etCBClienteHora, etCBClienteDireccion;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    static final String EXTRA_FECHA = "FECHA";
    static final String EXTRA_HORA = "HORA";
    static final String EXTRA_DIRECCION = "DIRECCION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbcliente);

        //TOAST COMPROBACIÓN SI HAY INTERNET
        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet", Toast.LENGTH_LONG)
                    .show();
        }

        //ENLAZO ELEMENTOS LAYOUT
        btnCBClienteFecha = findViewById(R.id.btnCBClienteFecha);
        etCBClienteFecha = findViewById(R.id.etCBClienteFecha);
        btnCBClienteHora = findViewById(R.id.btnCBClienteHora);
        etCBClienteHora = findViewById(R.id.etCBClienteHora);
        etCBClienteDireccion = findViewById(R.id.etCBClienteDireccion);

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

        Bundle b = getIntent().getExtras();
        if (b!=null){
            etCBClienteFecha.setText(getIntent().getExtras().getString(EXTRA_FECHA));
            etCBClienteHora.setText(getIntent().getExtras().getString(EXTRA_HORA));
            etCBClienteDireccion.setText(getIntent().getExtras().getString(EXTRA_DIRECCION));
        }

    }

    //BOTON VOLVER ANTERIOR ACTIVITY
    public void clickCBClienteVolverEmpresas(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), BBMenuClienteActivity.class);
        startActivity(i);
    }

    //BOTON VOLVER SIGUIENTE ACTIVITY
    public void clickCBClienteSeguirCita(View view) {
        Intent i = new Intent().setClass(getApplicationContext(), DAConfirmacionClienteActivity.class);

        i.putExtra(EXTRA_FECHA, etCBClienteFecha.getText().toString());
        i.putExtra(EXTRA_HORA, etCBClienteHora.getText().toString());
        i.putExtra(EXTRA_DIRECCION, etCBClienteDireccion.getText().toString());

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





