package com.edwinacubillos.itaguitur;

/**
 * Created by Edwin on 21/03/2017.
 */

public class Lista_Entrada {
    private int idImagen;
    private String nombre, descrip, direcc;

    //getter y setter
    public Lista_Entrada(int idImagen, String nombre, String descrip, String direcc) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.direcc = direcc;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }
}
