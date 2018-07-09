package com.example.lute.takeuappointment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ZAdaptadorProfesionales extends  RecyclerView.Adapter<ZAdaptadorProfesionales.ViewHolderClientes>{

    ArrayList<ZCliente> listaClientes;

    public ZAdaptadorProfesionales(ArrayList<ZCliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @NonNull
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
            hora= (TextView) itemView.findViewById(R.id.tvItemProfHora);
            nombre= (TextView) itemView.findViewById(R.id.tvItemProfNombre);
            datos= (EditText) itemView.findViewById(R.id.etItemProfDatos);
        }
    }
}
