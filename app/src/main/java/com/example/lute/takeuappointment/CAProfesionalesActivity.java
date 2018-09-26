package com.example.lute.takeuappointment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CAProfesionalesActivity extends AppCompatActivity {

    ImageView foto;
    ArrayList<ZCliente> listaClientes = new ArrayList<ZCliente>();
    ListView listCAProfesionales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caprofesionales);

        //TOAST COMPROBACIÓN SI HAY INTERNET
        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet", Toast.LENGTH_LONG)
                    .show();
        }



        //MOSTRAR LISTA DE CLIENTES
        datosClientes();

        listCAProfesionales = (ListView)findViewById(R.id.listCAProfesionales);

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
        listaClientes.add(new ZCliente("","","Melania Gallego de los Santos","","17:30","","","","","","","","","","","","","","foto1"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto2"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto3"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto4"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto5"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto6"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto7"));
        listaClientes.add(new ZCliente("","","","","","","","","","","","","","","","","","","foto8"));
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
