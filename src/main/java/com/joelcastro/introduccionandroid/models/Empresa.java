package com.joelcastro.introduccionandroid.models;

import com.googlecode.androidannotations.annotations.EBean;

import java.io.Serializable;

/**
 * Created by alu03009 on 21/01/14.
 */

public class Empresa implements Serializable {
    private String cif;
    private String nombre;
    private String sector;
    private String telefono;
    private String email;
    private String web;

    public Empresa(String cif, String nombre, String sector, String telefono, String email, String web) {
        this.cif = cif;
        this.nombre = nombre;
        this.sector = sector;
        this.telefono = telefono;
        this.email = email;
        this.web = web;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
