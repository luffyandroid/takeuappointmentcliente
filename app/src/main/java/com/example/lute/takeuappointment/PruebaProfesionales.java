package com.example.lute.takeuappointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PruebaProfesionales extends AppCompatActivity {

    ListView lvProfesional;
    ArrayList<ZProfesional> listaProf = new ArrayList<ZProfesional>();

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ZProfesional usu=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_profesionales);

        cargarDatosFirebase();

        lvProfesional = (ListView)findViewById(R.id.lvProfesional);


    }

    private void cargarListView (DataSnapshot dataSnapshot){

        //ZProfesional r =dataSnapshot.getValue(ZProfesional.class);


            listaProf.add(dataSnapshot.getValue(ZProfesional.class));

            ZAdaptadorProfesional adaptadorProfesional=new ZAdaptadorProfesional(this,listaProf);
            lvProfesional.setAdapter(adaptadorProfesional);

            /*lvProfesional.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ZProfesional c =((ZProfesional)parent.getItemAtPosition(position));
                    String nombre = c.getPnombre();
                    String usuario=c.getPapellidos();
                    String preparacion=c.getPempresa();
                    String foto=c.getPimagen();
                    ZProfesional recetaenviada=new ZProfesional(nombre, usuario, preparacion, foto);
                    Intent i = new Intent(getApplicationContext(), RecetaAbiertaActivity.class);
                    i.putExtra(EXTRA_RECETA, recetaenviada);
                    datosUsuario();
                    i.putExtra(EXTRA_USUARIO, usu);
                    startActivity(i);
                }
            });*/


    }

    private void cargarDatosFirebase(){


        dbRef = FirebaseDatabase.getInstance().getReference().child("pruebetic").child("profesionales");


        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaProf.clear();
                for (DataSnapshot recetaDataSnapshot : dataSnapshot.getChildren()) {
                    cargarListView(recetaDataSnapshot);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Prueba profesional", "DATABASE ERROR");
            }
        };

        dbRef.addValueEventListener(valueEventListener);

    }

}
