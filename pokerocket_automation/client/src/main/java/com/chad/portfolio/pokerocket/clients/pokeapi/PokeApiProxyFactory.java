package com.chad.portfolio.pokerocket.clients.pokeapi;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.*;

public class PokeApiProxyFactory {

    private final static List<?> PROVIDERS = Collections.singletonList(new JacksonJsonProvider());

    private PokeApiProxyFactory() {}

    public static PokeApiProxy Create(String url) {
        PokeApiProxy proxy = JAXRSClientFactory.create(url, PokeApiProxy.class, PROVIDERS);
        return proxy;
    }

}
