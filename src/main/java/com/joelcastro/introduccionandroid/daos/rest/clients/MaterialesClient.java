package com.joelcastro.introduccionandroid.daos.rest.clients;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;



@Rest(rootUrl = "https://api.parse.com/1/classes/",converters =  { MappingJacksonHttpMessageConverter.class })
public interface MaterialesClient {

    @Get("Materials")
    MaterialsResponse getAllMaterials();

    RestTemplate getRestTemplate();

}