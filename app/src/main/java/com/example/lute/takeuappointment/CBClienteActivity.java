package com.example.lute.takeuappointment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.time.Year;
import java.util.Calendar;

public class CBClienteActivity extends AppCompatActivity {

    //DECLARO INT VARIABLES CALENDARIO
    private int dia, mes, ano;

    //  //0
    private static final int DIALOGO = 0;

    //VARIABLE PARA PODER PICAR
    private static DatePickerDialog.OnDateSetListener SelecFecha;

    //DECLARO ELEMENTOS LAYOUT
    EditText etCBClienteFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbcliente);

        //ENLAZO ELEMENTOS LAYOUT
        etCBClienteFecha=(EditText)findViewById(R.id.etCBClienteFecha);

        //--

        //OBTENER FECHA ACTUAL
        Calendar calendario = Calendar.getInstance();

        //AÑADIR ELEMENTOS QUE RECOGERA EL CALENDARIO
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);

        //--

        //LLAMADA METODO MOSTRAR FECHA
        mostrarFecha();

        //PARA CAMBIAR LA FECHA AL PICAR
        SelecFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                //ENLAZAR INT CON LOS PICKERS
                dia = dayOfMonth;
                mes = month;
                ano = year;

                //LLAMADA METODO MOSTRAR FECHA
                mostrarFecha();

            }
        };

  }

    //ABRA EL DIALOGO PARA FECHA
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            //SI NO HUBIERA CAMBIOS VOLVERRÍA AL ANTERIOR
            case 0:
                //TIENE QUE PONERSE EN ESE ORDEN PARA QUE SALGA CON LA FECHA ACTUAL
                return new DatePickerDialog(this,SelecFecha, ano, mes, dia);
        }
        return null;
    }

    //CLICK ABRA DIALOGO
    public void clickCBClienteFecha(View control){
        showDialog(DIALOGO);
    }

    //METODO PARA MOSTRAR FECHA
    public void mostrarFecha(){
        etCBClienteFecha.setText(dia+"/"+(mes+1)+"/"+ano); //+1 PORQUE VA DEL 0 - 11

    }
}
