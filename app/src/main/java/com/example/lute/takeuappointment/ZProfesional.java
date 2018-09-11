package com.example.lute.takeuappointment;

import android.os.Parcel;
import android.os.Parcelable;

public class ZProfesional implements Parcelable{

    String pdni;
    String pcontrasena;
    String pnombre;
    String papellidos;
    String pempresa;
    String pdescripcion;
    String plugar;
    String pdireccion;
    int pimagen;
    String p1;
    String p2;
    String p3;
    String p4;
    String p5;
    String p6;
    String p7;
    String p8;
    String p9;

    public static final Parcelable.Creator<ZProfesional> CREATOR = new
            Parcelable.Creator<ZProfesional>(){
                public ZProfesional createFromParcel(Parcel in){
                    return new ZProfesional(in);
                }

                public ZProfesional[] newArray(int size){
                    return new ZProfesional[size];
                }

            };

    public ZProfesional(String pdni, String pcontrasena, String pnombre,
                        String papellidos, String pempresa, String pdescripcion,
                        String plugar, String pdireccion, int pimagen, String p1, String p2,
                        String p3, String p4, String p5, String p6, String p7, String p8, String p9) {
        this.pdni = pdni;
        this.pcontrasena = pcontrasena;
        this.pnombre = pnombre;
        this.papellidos = papellidos;
        this.pempresa = pempresa;
        this.pdescripcion = pdescripcion;
        this.plugar = plugar;
        this.pdireccion = pdireccion;
        this.pimagen = pimagen;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
    }

    public ZProfesional(Parcel p){
        readfromParcel(p);
    }

    public String getPdni() {
        return pdni;
    }

    public void setPdni(String pdni) {
        this.pdni = pdni;
    }

    public String getPcontrasena() {
        return pcontrasena;
    }

    public void setPcontrasena(String pcontrasena) {
        this.pcontrasena = pcontrasena;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getPapellidos() {
        return papellidos;
    }

    public void setPapellidos(String papellidos) {
        this.papellidos = papellidos;
    }

    public String getPempresa() {
        return pempresa;
    }

    public void setPempresa(String pempresa) {
        this.pempresa = pempresa;
    }

    public String getPdescripcion() {
        return pdescripcion;
    }

    public void setPdescripcion(String pdescripcion) {
        this.pdescripcion = pdescripcion;
    }

    public String getPlugar() {
        return plugar;
    }

    public void setPlugar(String plugar) {
        this.plugar = plugar;
    }

    public String getPdireccion() {
        return pdireccion;
    }

    public void setPdireccion(String pdireccion) {
        this.pdireccion = pdireccion;
    }

    public int getPimagen() {
        return pimagen;
    }

    public void setPimagen(int pimagen) {
        this.pimagen = pimagen;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pdni);
        dest.writeString(this.pcontrasena);
        dest.writeString(this.pnombre);
        dest.writeString(this.papellidos);
        dest.writeString(this.pempresa);
        dest.writeString(this.pdescripcion);
        dest.writeString(this.plugar);
        dest.writeString(this.pdireccion);
        dest.writeString(this.p1);
        dest.writeString(this.p2);
        dest.writeString(this.p3);
        dest.writeString(this.p4);
        dest.writeString(this.p5);
        dest.writeString(this.p6);
        dest.writeString(this.p7);
        dest.writeString(this.p8);
        dest.writeString(this.p9);
        dest.writeInt(this.pimagen);

    }
    private void readfromParcel(Parcel p){
        this.pdni = p.readString();
        this.pcontrasena = p.readString();
        this.pnombre = p.readString();
        this.papellidos = p.readString();
        this.pempresa = p.readString();
        this.pdescripcion = p.readString();
        this.plugar = p.readString();
        this.plugar = p.readString();
        this.pdireccion = p.readString();
        this.p1 = p.readString();
        this.p2 = p.readString();
        this.p3 = p.readString();
        this.p4 = p.readString();
        this.p5 = p.readString();
        this.p6 = p.readString();
        this.p7 = p.readString();
        this.p8 = p.readString();
        this.p9 = p.readString();
        this.pimagen = p.readInt();
    }
}