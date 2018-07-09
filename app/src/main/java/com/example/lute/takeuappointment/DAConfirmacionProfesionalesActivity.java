package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DAConfirmacionProfesionalesActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS LAYOUT
    TextView tvDAConfProfesionalesUsuario, tvDAConfProfesionalesNombre, tvDAConfProfesionalesApellidos, tvDAConfProfesionalesFecha, tvDAConfProfesionalesHora, tvDAConfProfesionalesLugar, tvDAConfProfesionalesDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daconfirmacion_profesionales);

        //ENLAZO ELEMENTOS LAYOUT
        tvDAConfProfesionalesUsuario=(TextView)findViewById(R.id.tvDAConfProfesionalesUsuario);
        tvDAConfProfesionalesNombre=(TextView)findViewById(R.id.tvDAConfProfesionalesNombre);
        tvDAConfProfesionalesApellidos=(TextView)findViewById(R.id.tvDAConfProfesionalesApellidos);
        tvDAConfProfesionalesFecha=(TextView)findViewById(R.id.tvDAConfProfesionalesFecha);
        tvDAConfProfesionalesHora=(TextView)findViewById(R.id.tvDAConfProfesionalesHora);
        tvDAConfProfesionalesLugar=(TextView)findViewById(R.id.tvDAConfProfesionalesLugar);
        tvDAConfProfesionalesDireccion=(TextView)findViewById(R.id.tvDAConfProfesionalesDireccion);
    }

    //BOTON PROVISIONAL
    public void ClickLogin4(View view){
        Intent i = new Intent().setClass(getApplicationContext(), BALoginActivity.class);
        startActivity(i);
    }

}
