package com.joelcastro.introduccionandroid.models;

import java.io.Serializable;

/**
 * Created by alu03009 on 18/01/14.
 */
public class Deposito implements Serializable {

    private int id;
    private String depositanteId;
    private String fecha;
    private String peso;
    private Boolean it,oil,fridges;

    public Deposito(int id, String depositanteId, String fecha, String peso, Boolean it, Boolean oil, Boolean fridges) {
        this.id = id;
        this.depositanteId = depositanteId;
        this.fecha = fecha;
        this.peso = peso;
        this.it = it;
        this.oil = oil;
        this.fridges = fridges;
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
}
