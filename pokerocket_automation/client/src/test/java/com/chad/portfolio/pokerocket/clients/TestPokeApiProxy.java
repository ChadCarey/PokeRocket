package com.chad.portfolio.pokerocket.clients;

import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxyFactory;
import com.chad.portfolio.pokerocket.clients.pokeapi.beans.PokeApiPokemon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPokeApiProxy {

    private final static String url = "https://pokeapi.co/api/v2";
    private final static Integer BULBASAUR = 1;
    @Test
    public void testGetPokemon() {
        PokeApiProxy proxy = PokeApiProxyFactory.Create(url);
        Assert.assertNotNull(proxy);
        PokeApiPokemon poke = null;
        try {
            poke = proxy.getPokemonById(BULBASAUR);
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
        Assert.assertNotNull(poke);
        Assert.assertEquals(poke.getId(), BULBASAUR);
    }

}
