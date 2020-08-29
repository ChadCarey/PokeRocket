package com.chad.portfolio.pokerocket.clients.pokerocketendpoints;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.*;

public class PokeRocketEndpointsProxyFactory {

    private final static List<?> PROVIDERS = Collections.singletonList(new JacksonJsonProvider());

    private PokeRocketEndpointsProxyFactory() {}

    public static PokeRocketEndpointsProxy Create(String url) {
        PokeRocketEndpointsProxy proxy = JAXRSClientFactory.create(url, PokeRocketEndpointsProxy.class, PROVIDERS);
        return proxy;
    }

}
