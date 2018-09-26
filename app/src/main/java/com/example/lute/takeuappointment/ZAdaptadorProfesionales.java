package com.example.lute.takeuappointment;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ZAdaptadorProfesionales extends ArrayAdapter<ZCliente>{

    ArrayList<ZCliente> listaClientes;
    Context c;
    StorageReference storageRf;

    public ZAdaptadorProfesionales(Context c, ArrayList<ZCliente> listaClientes) {
        super(c, R.layout.item_profesional, listaClientes);
        this.listaClientes = listaClientes;
        this.c = c;
        this.storageRf = FirebaseStorage.getInstance().getReference();
    }

    /*@NonNull
    @Override
    public ViewHolderClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_profesional,null,false);

        return new ViewHolderClientes(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderClientes holder, int position) {
        holder.hora.setText(listaClientes.get(position).getChora());
        holder.nombre.setText(listaClientes.get(position).getCnombre());
        //holder.datos.setText(listaClientes.get(position).getC1());
        holder.imagen.setImageResource(listaClientes.get(position).getCimagen());

        cargarImagen(imagen, item, iv_logo);
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ViewHolderClientes extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView hora, nombre;
        EditText datos;

        public ViewHolderClientes(View itemView) {
            super(itemView);
            imagen= (ImageView) itemView.findViewById(R.id.ivItemProfImagen);
            hora= (TextView) itemView.findViewById(R.id.tvItemProfFecha);
            nombre= (TextView) itemView.findViewById(R.id.tvItemProfNombre);
            datos= (EditText) itemView.findViewById(R.id.tvItemProfDatos);
        }
    }*/

    public View getView(int position, View view, ViewGroup viewgroup) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_profesional, null);
        TextView nombre = (TextView)item.findViewById(R.id.tvItemProfNombre);
        nombre.setText(listaClientes.get(position).getCnombre());
        TextView hora = (TextView)item.findViewById(R.id.tvItemProfFecha);
        hora.setText(listaClientes.get(position).getChora());
        TextView datos = (TextView)item.findViewById(R.id.tvItemProfDatos);
        datos.setText(listaClientes.get(position).getC1());

        String imagen = listaClientes.get(position).getCimagen();
        ImageView ivImagen = (ImageView) item.findViewById(R.id.ivItemProfImagen);

        cargarImagen(imagen, item, ivImagen);

        return item;

    }

    private void cargarImagen(String nombre, final View item, final ImageView ivImagen){

        storageRf.child("imagenes/recetas/"+nombre).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(item).load(uri.toString()).into(ivImagen);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

}
