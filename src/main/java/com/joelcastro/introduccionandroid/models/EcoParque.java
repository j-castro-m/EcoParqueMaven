package com.joelcastro.introduccionandroid.models;

import java.io.Serializable;

/**
 * Created by alu03009 on 18/01/14.
 */
public class EcoParque implements Serializable{

    private String id;
    private String lugar;
    private String image;

    public EcoParque(String id, String image, String lugar) {
        this.id = id;
        this.image = image;
        this.lugar = lugar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
