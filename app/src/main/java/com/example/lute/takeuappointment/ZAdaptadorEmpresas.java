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

public class ZAdaptadorEmpresas extends  RecyclerView.Adapter<ZAdaptadorEmpresas.ViewHolderProfesional>{

    ArrayList<ZProfesional> listaEmpresas;

    public ZAdaptadorEmpresas(ArrayList<ZProfesional> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    @NonNull
    @Override
    public ViewHolderProfesional onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menucliente,null,false);

        return new ViewHolderProfesional(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderProfesional holder, int position) {
        holder.descripcion.setText(listaEmpresas.get(position).getPdescripcion());
        holder.empresa.setText(listaEmpresas.get(position).getPempresa());
        holder.direccion.setText(listaEmpresas.get(position).getPdireccion());
        //holder.datos.setText(listaClientes.get(position).getP1());
        //holder.imagen.setImageResource(listaEmpresas.get(position).getPimagen());

    }

    @Override
    public int getItemCount() {
        return listaEmpresas.size();
    }

    public class ViewHolderProfesional extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView descripcion, empresa, direccion;

        public ViewHolderProfesional(View itemView) {
            super(itemView);
            imagen= (ImageView) itemView.findViewById(R.id.ivItemMenuClienteImagen);
            direccion= (TextView) itemView.findViewById(R.id.tvItemMenuClienteDireccion);
            empresa= (TextView) itemView.findViewById(R.id.tvItemMenuClienteEmpresa);
            descripcion= (TextView) itemView.findViewById(R.id.tvItemMenuClienteDescripcion);
        }
    }
}
