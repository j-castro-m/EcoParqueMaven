package com.joelcastro.introduccionandroid.models;

/**
 * Created by alu03009 on 21/01/14.
 */
public class DepositoMaterial {
    private int idDeposito;
    private int idMaterial;

    public DepositoMaterial(int idDeposito, int idMaterial) {
        this.idDeposito = idDeposito;
        this.idMaterial = idMaterial;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }
}
