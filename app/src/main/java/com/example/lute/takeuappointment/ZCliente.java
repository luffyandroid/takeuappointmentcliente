package com.example.lute.takeuappointment;

import android.os.Parcel;
import android.os.Parcelable;

public class ZCliente implements Parcelable{

    String cusuario;
    String ccontrasena;
    String cnombre;
    String cfecha;
    String chora;
    String clugar;
    String cdireccion;
    String cprofesional;
    String c1;
    String c2;
    String c3;
    String c4;
    String c5;
    String c6;
    String c7;
    String c8;
    String c9;
    String c10;
    int cimagen;

    public static final Parcelable.Creator<ZCliente> CREATOR = new
            Parcelable.Creator<ZCliente>(){
        public ZCliente createFromParcel(Parcel in){
            return new ZCliente(in);
        }

        public ZCliente[] newArray(int size){
            return new ZCliente[size];
        }

    };

    //public ZCliente(){}


    public ZCliente(String cusuario, String ccontrasena, String cnombre,
                    String cfecha, String chora, String clugar, String cdireccion,
                    String cprofesional, String c1, String c2, String c3, String c4, String c5,
                    String c6, String c7, String c8, String c9, String c10, int cimagen) {
        this.cusuario = cusuario;
        this.ccontrasena = ccontrasena;
        this.cnombre = cnombre;
        this.cfecha = cfecha;
        this.chora = chora;
        this.clugar = clugar;
        this.cdireccion = cdireccion;
        this.cprofesional = cprofesional;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
        this.c9 = c9;
        this.c10 = c10;
        this.cimagen = cimagen;
    }

    public ZCliente(Parcel p){
        readfromParcel(p);
    }


    public String getCusuario() {
        return cusuario;
    }

    public void setCusuario(String cusuario) {
        this.cusuario = cusuario;
    }

    public String getCcontrasena() {
        return ccontrasena;
    }

    public void setCcontrasena(String ccontrasena) {
        this.ccontrasena = ccontrasena;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCfecha() {
        return cfecha;
    }

    public void setCfecha(String cfecha) {
        this.cfecha = cfecha;
    }

    public String getChora() {
        return chora;
    }

    public void setChora(String chora) {
        this.chora = chora;
    }

    public String getClugar() {
        return clugar;
    }

    public void setClugar(String clugar) {
        this.clugar = clugar;
    }

    public String getCdireccion() {
        return cdireccion;
    }

    public void setCdireccion(String cdireccion) {
        this.cdireccion = cdireccion;
    }

    public String getCprofesional() {
        return cprofesional;
    }

    public void setCprofesional(String cprofesional) {
        this.cprofesional = cprofesional;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

    public String getC7() {
        return c7;
    }

    public void setC7(String c7) {
        this.c7 = c7;
    }

    public String getC8() {
        return c8;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    public String getC9() {
        return c9;
    }

    public void setC9(String c9) {
        this.c9 = c9;
    }

    public String getC10() {
        return c10;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public int getCimagen() {
        return cimagen;
    }

    public void setCimagen(int cimagen) {
        this.cimagen = cimagen;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cusuario);
        dest.writeString(this.ccontrasena);
        dest.writeString(this.cnombre);
        dest.writeString(this.cfecha);
        dest.writeString(this.chora);
        dest.writeString(this.clugar);
        dest.writeString(this.cdireccion);
        dest.writeString(this.cprofesional);
        dest.writeString(this.c1);
        dest.writeString(this.c2);
        dest.writeString(this.c3);
        dest.writeString(this.c4);
        dest.writeString(this.c5);
        dest.writeString(this.c6);
        dest.writeString(this.c7);
        dest.writeString(this.c8);
        dest.writeString(this.c9);
        dest.writeString(this.c10);
        dest.writeInt(this.cimagen);

    }

    private void readfromParcel(Parcel p){
        this.cusuario = p.readString();
        this.ccontrasena = p.readString();
        this.cnombre = p.readString();
        this.cfecha = p.readString();
        this.chora = p.readString();
        this.clugar = p.readString();
        this.clugar = p.readString();
        this.cdireccion = p.readString();
        this.cprofesional = p.readString();
        this.c1 = p.readString();
        this.c2 = p.readString();
        this.c3 = p.readString();
        this.c4 = p.readString();
        this.c5 = p.readString();
        this.c6 = p.readString();
        this.c7 = p.readString();
        this.c8 = p.readString();
        this.c9 = p.readString();
        this.c10 = p.readString();
        this.cimagen = p.readInt();
    }
}