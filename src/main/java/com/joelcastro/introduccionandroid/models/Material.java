package com.joelcastro.introduccionandroid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by alu03009 on 10/01/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Material implements Serializable {
    private int id;
    private String name;

    public Material() {
    }

    public Material(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
