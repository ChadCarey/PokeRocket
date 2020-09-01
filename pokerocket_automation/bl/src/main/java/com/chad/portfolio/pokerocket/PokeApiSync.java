package com.chad.portfolio.pokerocket;

import com.chad.portfolio.pokerocket.clients.pokeapi.PokeApiProxy;
import com.chad.portfolio.pokerocket.clients.pokeapi.adapters.PokeApiAdapters;
import com.chad.portfolio.pokerocket.clients.pokeapi.beans.PokeApiPokemon;
import com.chad.portfolio.pokerocket.clients.pokerocketendpoints.PokeRocketEndpointsProxy;
import com.chad.portfolio.pokerocket.model.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PokeApiSync
 * Contains methods for synchronizing PokeApi with PokeRocket
 */
public class PokeApiSync {

    private static Logger log = LoggerFactory.getLogger(PokeApiSync.class);

    private final NextPokemonResolver nextPokemonResolver;
    private final PokeApiProxy pokeApi;
    private final PokeRocketEndpointsProxy pokeRocket;


    public PokeApiSync(NextPokemonResolver nextPokemonResolver, PokeApiProxy pokeApi, PokeRocketEndpointsProxy pokeRocket) {
        this.nextPokemonResolver = nextPokemonResolver;
        this.pokeApi = pokeApi;
        this.pokeRocket = pokeRocket;
    }


    /**
     * Uses NextPokemonResolver to look up what the next pokemon that needs to be synced is and then syncs it
     */
    public Integer syncNext() {
        Integer dbId = null;
        Integer nextPokedexId = this.nextPokemonResolver.getNextPokedeId();

        if(nextPokedexId > 0) {
            log.info("attempting to download pokemon: " + nextPokedexId);
            PokeApiPokemon pokeApiPokemon = pokeApi.getPokemonById(nextPokedexId);
            if(isPokemonAlreadyInPokerocketDb(pokeApiPokemon.getId())){
                dbId = updatePokemon(pokeApiPokemon);
            } else {
                dbId = addPokemon(pokeApiPokemon);
            }
        }

        return dbId;
    }


    private Integer addPokemon(PokeApiPokemon pokeApiPokemon) {

        Integer newPokemonId = null;

        try {
            Pokemon pokemon = PokeApiAdapters.FromPokeApi(pokeApiPokemon);
            newPokemonId = pokeRocket.addPokemon(pokemon);
            log.info("added pokemon with dbId: " + newPokemonId);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            newPokemonId = null;
        }

        return newPokemonId;

    }


    private Integer updatePokemon(PokeApiPokemon pokeApiPokemon) {
        // TODO: implement!
        log.warn("UPDATE POKEMON NOT IMPLEMENTED. Ignoring update.");
        log.info("updating pokemon " + pokeApiPokemon.getId());
        Pokemon pokemon = pokeRocket.getPokemonByPokedexId(pokeApiPokemon.getId());
        return pokemon.getId();
    }


    private Boolean isPokemonAlreadyInPokerocketDb(Integer pokedexId) {
        Pokemon pokemon = this.pokeRocket.getPokemonByPokedexId(pokedexId);
        return pokemon != null && pokemon.getPokedexId().equals(pokedexId);
    }

}
