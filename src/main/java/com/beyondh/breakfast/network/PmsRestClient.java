package com.beyondh.breakfast.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Component
public class PmsRestClient {

    @Value("${proxy.enabled}")
    private boolean proxyEnabled;
    @Value("${proxy.host}")
    private String proxyHost;

    @Value("${proxy.port}")
    private int proxyPort;

    @Autowired
    private RestTemplate restTemplate;


    public RestTemplate GetClient(){
        if(proxyEnabled){
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setProxy(new Proxy(java.net.Proxy.Type.HTTP,new InetSocketAddress(proxyHost, proxyPort)));
        }

        return restTemplate;
    }

}
