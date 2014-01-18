package com.joelcastro.introduccionandroid.daos.rest;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;
import com.joelcastro.introduccionandroid.daos.rest.clients.MaterialesClient;
import com.joelcastro.introduccionandroid.daos.rest.clients.MaterialsResponse;
import com.joelcastro.introduccionandroid.models.Material;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alu03009 on 18/01/14.
 */
@EBean
public class MaterialesRestDAO implements MaterialesDAO
{
    @RestService
    MaterialesClient materialesClient;

    @Override
    public List<Material> getAllMateriales() {
        try {
            MaterialsResponse materialsResponse = materialesClient.getAllMaterials();
            return materialsResponse.getResults();
        } catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Bean
    ParseHeadersInterceptor parseHeadersInterceptor;

    @AfterInject
    void initAuth() {

        RestTemplate template = materialesClient.getRestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(parseHeadersInterceptor);

        template.setInterceptors(interceptors);
    }
}