package com.joelcastro.introduccionandroid.models;

import java.io.Serializable;

/**
 * Created by alu03009 on 18/01/14.
 */
public class Deposito implements Serializable {

    private int id;
    private int idEcoParque;
    private String depositanteId;
    private String fecha;
    private String peso;
    private Boolean it,oil,fridges;
    private Boolean company;
    private String nombre;
    private String sector;
    private String telefono;
    private String email;
    private String web;

    public Deposito(int id,int idEcoParque, String depositanteId, String fecha, String peso, Boolean it, Boolean oil, Boolean fridges, Boolean company, String nombre, String sector, String telefono, String email, String web) {
        this.id = id;
        this.depositanteId = depositanteId;
        this.fecha = fecha;
        this.peso = peso;
        this.it = it;
        this.oil = oil;
        this.fridges = fridges;
        this.company = company;
        this.nombre = nombre;
        this.sector = sector;
        this.telefono = telefono;
        this.email = email;
        this.web = web;
        this.idEcoParque=idEcoParque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Boolean getIt() {
        return it;
    }

    public void setIt(Boolean it) {
        this.it = it;
    }

    public Boolean getOil() {
        return oil;
    }

    public void setOil(Boolean oil) {
        this.oil = oil;
    }

    public Boolean getFridges() {
        return fridges;
    }

    public void setFridges(Boolean fridges) {
        this.fridges = fridges;
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

    public int getIdEcoParque() {
        return idEcoParque;
    }

    public void setIdEcoParque(int idEcoParque) {
        this.idEcoParque = idEcoParque;
    }
}
