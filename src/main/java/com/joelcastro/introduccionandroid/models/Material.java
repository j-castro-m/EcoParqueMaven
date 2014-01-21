package com.joelcastro.introduccionandroid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by alu03009 on 10/01/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Material implements Serializable {
    private String id_material;
    private String name;

    public Material() {
    }

    public Material(String id_material, String name) {
        this. id_material = id_material;
        this.name = name;
    }

    public void setId(String id) {
        this.id_material =  id_material;
    }

    public String getId() {
        return  id_material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
