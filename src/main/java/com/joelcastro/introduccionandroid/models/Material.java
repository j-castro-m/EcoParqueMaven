package com.joelcastro.introduccionandroid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by alu03009 on 10/01/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Material {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
