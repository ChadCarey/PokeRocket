package com.chad.portfolio.pokerocket.impl;

import com.chad.portfolio.pokerocket.NextPokemonResolver;

/**
 *  NOTE: this is a placeholder implementation. Not best practice in production environment
 */
public class StatefullNextPokemonResolver implements NextPokemonResolver {
    public static final Integer MAX_POKEDEX_ID = 800;
    public static final Integer OUT_OF_POKEMON = -1;
    private Integer currentPokedexId = 0;

    public Integer getNextPokedeId() {
        if(this.currentPokedexId >= MAX_POKEDEX_ID){
            return OUT_OF_POKEMON;
        } else {
            this.currentPokedexId += 1;
            return currentPokedexId;
        }
    }
}
