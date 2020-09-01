package com.chad.portfolio.pokerocket;

import com.chad.portfolio.pokerocket.clients.DnsResolver;
import com.chad.portfolio.pokerocket.clients.docker.DockerDnsResolver;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxyFactory;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxy;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxyFactory;
import com.chad.portfolio.pokerocket.impl.StatefullNextPokemonResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

public class TestPokeApiSync {

    private Logger log = LoggerFactory.getLogger(TestPokeApiSync.class);

    @Test
    public void testSyncNext() {
        DnsResolver resolver = new DockerDnsResolver();
        String pokerocketUrl = null;
        // TODO: get url from environment/config
        String pokeApiUrl = "https://pokeapi.co/api/v2";
        PokeApiProxy pokeApiProxy = PokeApiProxyFactory.Create(pokeApiUrl);
        Assert.assertNotNull(pokeApiProxy);

        try {
            // TODO: get port and alias from config/environment
            pokerocketUrl = "http://"+resolver.getIpFromAlias("pokerocket_endpoints")+":5000";
        } catch (UnknownHostException e) {
            Assert.fail(e.getMessage(), e);
        }
        PokeRocketEndpointsProxy pokerocketProxy = PokeRocketEndpointsProxyFactory.Create(pokerocketUrl);
        Assert.assertNotNull(pokerocketProxy);

        log.info("pokerocket_endpoints url = "+pokerocketUrl);
        log.info("pokeApi url = "+pokeApiUrl);

        PokeApiSync pokeApiSync = new PokeApiSync(
            new StatefullNextPokemonResolver(),
            pokeApiProxy,
            pokerocketProxy
        );
        Integer syncedPokemon = pokeApiSync.syncNext();
        Assert.assertTrue(syncedPokemon > 0);
    }

}
