package com.chad.portfolio.pokerocket.impl;

import com.chad.portfolio.pokerocket.NextPokemonResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  NOTE: this is a placeholder implementation. Not best practice in production environment
 */
public class StatefullNextPokemonResolver implements NextPokemonResolver {

    private static Logger log = LoggerFactory.getLogger(StatefullNextPokemonResolver.class);

    public static final Integer MAX_POKEDEX_ID = 800;
    public static final Integer OUT_OF_POKEMON = -1;
    private Integer currentPokedexId = 0;


    synchronized public Integer getNextPokedeId() {

        log.warn("Using StatefullNextPokemonResolver to resolve the next pokedex id.");

        if(this.currentPokedexId >= MAX_POKEDEX_ID){
            log.info("Reached max pokemon id. Starting over.");
            this.currentPokedexId = 0;
        }

        this.currentPokedexId += 1;
        return currentPokedexId;

    }
}
