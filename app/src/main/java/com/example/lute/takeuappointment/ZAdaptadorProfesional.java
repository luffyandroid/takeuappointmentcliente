package com.example.lute.takeuappointment;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ZAdaptadorProfesional extends ArrayAdapter<ZProfesional>{

    ArrayList<ZProfesional> profesional;
    Context p;
    StorageReference storageRF;
    public ZAdaptadorProfesional(Context p, ArrayList<ZProfesional> profesional) {
        super(p, R.layout.item_profesional, profesional);
        this.profesional = profesional;
        this.p = p;
        this.storageRF = FirebaseStorage.getInstance().getReference();
    }
    public View getView(int position, View view, ViewGroup
            viewGroup) {
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_profesional, null);

        TextView tvNombre = (TextView)
                item.findViewById(R.id.tvItemProfNombre);
        tvNombre.setText(profesional.get(position).getPnombre() );

        TextView tvApellidos = (TextView)
                item.findViewById(R.id.tvItemProfFecha);
        tvApellidos.setText(profesional.get(position).getPapellidos() );

        TextView tvEmpresa = (TextView)
                item.findViewById(R.id.tvItemProfDatos);
        tvEmpresa.setText(profesional.get(position).getPempresa() );


        String imagen = profesional.get(position).getPimagen();
        /*int idImagen = c.getResources().getIdentifier(imagen,"drawable", c.getPackageName());*/
        ImageView iv_logo = (ImageView) item.findViewById(R.id.ivItemProfImagen);
        /*iv_logo.setImageResource(idImagen);*/

        cargarImagen(imagen, item, iv_logo);

        return item;
    }

    private void cargarImagen(String nombre, final View item, final ImageView iv_logo){

        storageRF.child("images/"+nombre).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(item).load(uri.toString()).into(iv_logo);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

}
