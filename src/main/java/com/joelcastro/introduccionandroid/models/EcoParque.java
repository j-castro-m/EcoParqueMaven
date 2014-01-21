package com.joelcastro.introduccionandroid.models;

import java.io.Serializable;

/**
 * Created by alu03009 on 18/01/14.
 */
public class EcoParque implements Serializable{

    private String id_ecoparque;
    private String lugar;
    private String image;

    public EcoParque() {

    }
    public EcoParque(String id_ecoparque, String lugar, String image) {
        this.id_ecoparque = id_ecoparque;
        this.image = image;
        this.lugar = lugar;
    }

    public String getId() {
        return id_ecoparque;
    }

    public void setId(String id_ecoparque) {
        this.id_ecoparque = id_ecoparque;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
