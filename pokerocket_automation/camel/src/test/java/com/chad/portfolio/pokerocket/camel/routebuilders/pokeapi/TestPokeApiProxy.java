package com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi;

import com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi.beans.PokeApiPokemon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPokeApiProxy {

    private final static String pokeApiUrl = "https://pokeapi.co/api/v2";

    @Test
    public void testGetPokemonById() {
        PokeApiProxy pokeApiProxy = PokeApiProxyFactory.Create(pokeApiUrl);
        PokeApiPokemon pokeApiPokemon = null;
        try {
            pokeApiPokemon = pokeApiProxy.getPokemonById(1);
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
        Assert.assertNotNull(pokeApiPokemon);
    }

}
