package com.beyondh.breakfast.network;

import com.beyondh.breakfast.interceptor.RequestCallContext;
import com.beyondh.breakfast.utils.CookieCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

@Component
public class PmsRestClient {

    @Value("${proxy.enabled}")
    private boolean proxyEnabled;
    @Value("${proxy.host}")
    private String proxyHost;

    @Value("${proxy.port}")
    private int proxyPort;

    private String cookie="Shift=3; SessionId=C02C3E2C-1748-4662-BD76-B6D62E477769; OwnerId=164-249-252-54-237-28-162-142-252-143-97-116-230-13-68-69; LoginOrgId=191-177-10-23-134-199-115-171-28-141-251-210-49-27-53-105; Token=94966AFF-8BBD-40B8-8506-8C3AD0CEC721; StorageKey=CB322B73F853C5A62022F531BDACB33BC47479F4; IsShowByhHelp=true; tutorialAddress=http://tutorial.beyondh.com?r=; OperateOrgId=191-177-10-23-134-199-115-171-28-141-251-210-49-27-53-105";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RequestCallContext requestCallContext;

    public PmsRestClient() {
    }

    public RestTemplate GetClient() {
        if (proxyEnabled) {
            proxyEnabled = false;
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setProxy(new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
        }

        if (restTemplate.getInterceptors().size() == 0 || restTemplate.getInterceptors().size() == 1) {
            List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
            interceptors.add(new HttpHeaderInterceptor(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE));
            if (null != requestCallContext.GetUser()) {
                interceptors.add(new HttpHeaderInterceptor(HttpHeaders.COOKIE, CookieCache.Get(requestCallContext.GetUser())));
            }
            restTemplate.setInterceptors(interceptors);
        }

        return restTemplate;
    }

}
