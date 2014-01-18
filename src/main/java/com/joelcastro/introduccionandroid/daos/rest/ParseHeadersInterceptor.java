package com.joelcastro.introduccionandroid.daos.rest;

import com.googlecode.androidannotations.annotations.EBean;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@EBean
public class ParseHeadersInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        HttpHeaders headers = httpRequest.getHeaders();
        headers.add("X-Parse-Application-Id","Grq8XIUzocFAMK43754Wfko7uEllXGBn6go236hV");
        headers.add("X-Parse-REST-API-Key","yu8NSFkx2VmSEbdGZRGKGoEoghRQJpa3bs1bvBEu");

        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, body);
        return response;
    }
}