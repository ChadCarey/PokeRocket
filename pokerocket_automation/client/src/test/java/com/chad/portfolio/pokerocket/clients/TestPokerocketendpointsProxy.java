package com.chad.portfolio.pokerocket.clients;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.chad.portfolio.pokerocket.clients.docker.DockerDnsResolver;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxyFactory;
import com.chad.portfolio.pokerocket.clients.pokeapi.beans.PokeApiPokemon;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxy;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxyFactory;
import com.chad.portfolio.pokerocket.model.Pokemon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jdk.internal.jline.internal.Log;

public class TestPokerocketendpointsProxy {

    private static Logger log = LoggerFactory.getLogger(TestPokerocketendpointsProxy.class);

    Integer port = 5000;

    private String url;
    private final static Integer BULBASAUR = 1;
    private DnsResolver dnsResolver = new DockerDnsResolver();

    public TestPokerocketendpointsProxy() {
        try {
            String ip = dnsResolver.getIpFromAlias("pokerocket_endpoints");
            this.url = "http://"+ ip+":"+port;
        } catch (UnknownHostException e) {
            log.info("unable to get pokerocket_endpoints ip");
        }
    }

    @Test
    public void testGetPokemon() {
        log.info("url: "+ url);
        PokeRocketEndpointsProxy proxy = PokeRocketEndpointsProxyFactory.Create(url);
        Assert.assertNotNull(proxy);
        Pokemon poke = null;
        try {
            poke = proxy.getPokemonById(1);
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
        Assert.assertNotNull(poke);
        Assert.assertEquals(poke.getId(), (Integer)1);
    }

}
