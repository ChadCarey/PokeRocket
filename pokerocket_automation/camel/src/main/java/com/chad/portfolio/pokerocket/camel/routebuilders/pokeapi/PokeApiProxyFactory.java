package com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.Collections;
import java.util.List;

public class PokeApiProxyFactory {

    private final static List<?> PROVIDERS = Collections.singletonList(new JacksonJsonProvider());

    private PokeApiProxyFactory() {}

    public static PokeApiProxy Create(String url) {
        PokeApiProxy proxy = JAXRSClientFactory.create(url, PokeApiProxy.class, PROVIDERS);
        return proxy;
    }

}
