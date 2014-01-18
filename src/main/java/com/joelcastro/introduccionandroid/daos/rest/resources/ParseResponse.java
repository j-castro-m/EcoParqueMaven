package com.joelcastro.introduccionandroid.daos.rest.resources;

import java.util.List;

/**
 * Created by alu03009 on 18/01/14.
 */
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParseResponse<E> {

    List<E> results;

    public List<E> getResults() {
        return results;
    }

    public void setResults(List<E> results) {
        this.results = results;
    }
}