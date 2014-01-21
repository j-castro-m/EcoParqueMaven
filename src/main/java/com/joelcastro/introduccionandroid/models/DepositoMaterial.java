package com.joelcastro.introduccionandroid.models;

/**
 * Created by alu03009 on 21/01/14.
 */
public class DepositoMaterial {
    private String idDeposito;
    private String idMaterial;

    public DepositoMaterial() {
    }

    public DepositoMaterial(String idDeposito, String idMaterial) {
        this.idDeposito = idDeposito;
        this.idMaterial = idMaterial;
    }

    public String getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(String idDeposito) {
        this.idDeposito = idDeposito;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }
}
