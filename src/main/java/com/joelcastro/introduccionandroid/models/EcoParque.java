package com.joelcastro.introduccionandroid.models;

import java.io.Serializable;

/**
 * Created by alu03009 on 18/01/14.
 */
public class EcoParque implements Serializable{

    private int id;
    private String lugar;
    private String image;

    public EcoParque(int id, String lugar, String image) {
        this.id = id;
        this.image = image;
        this.lugar = lugar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
