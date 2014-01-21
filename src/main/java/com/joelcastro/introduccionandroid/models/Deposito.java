package com.joelcastro.introduccionandroid.models;

import java.io.Serializable;

/**
 * Created by alu03009 on 18/01/14.
 */
public class Deposito implements Serializable {

    private String id_deposito;
    private String idEcoParque;
    private String depositanteId;
    private String fecha;
    private String peso;
    private Boolean company;
    private String nombre;
    private String sector;
    private String telefono;
    private String email;
    private String web;

    public Deposito() {
    }

    public Deposito(String id_deposito,String idEcoParque, String depositanteId, String fecha, String peso, Boolean company, String nombre, String sector, String telefono, String email, String web) {
        this.id_deposito = id_deposito;
        this.depositanteId = depositanteId;
        this.fecha = fecha;
        this.peso = peso;
        this.company = company;
        this.nombre = nombre;
        this.sector = sector;
        this.telefono = telefono;
        this.email = email;
        this.web = web;
        this.idEcoParque=idEcoParque;
    }

    public Deposito(String id_deposito,String idEcoParque, String depositanteId, String fecha, String peso) {
        this.id_deposito = id_deposito;
        this.depositanteId = depositanteId;
        this.fecha = fecha;
        this.peso = peso;
        this.company=Boolean.FALSE;
        this.idEcoParque=idEcoParque;
        this.nombre="";
        this.sector="";
        this.telefono="";
        this.email="";
        this.web="";
    }

    public Deposito(String id_deposito,String idEcoParque, String depositanteId, String fecha, String peso, Empresa empresa) {
        this.id_deposito = id_deposito;
        this.depositanteId = empresa.getCif();
        this.fecha = fecha;
        this.peso = peso;
        this.company = Boolean.TRUE;
        this.nombre = empresa.getNombre();
        this.sector = empresa.getSector();
        this.telefono = empresa.getTelefono();
        this.email = empresa.getEmail();
        this.web = empresa.getWeb();
        this.idEcoParque=idEcoParque;
    }

    public String getId() {
        return id_deposito;
    }

    public void setId(String id_deposito) {
        this.id_deposito = id_deposito;
    }

    public String getDepositanteId() {
        return depositanteId;
    }

    public void setDepositanteId(String depositanteId) {
        this.depositanteId = depositanteId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Boolean getCompany() {
        return company;
    }

    public void setCompany(Boolean company) {
        this.company = company;
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

    public String getIdEcoParque() {
        return idEcoParque;
    }

    public void setIdEcoParque(String idEcoParque) {
        this.idEcoParque = idEcoParque;
    }
}
