package com.chad.portfolio.pokerocket.clients.pokerocketendpoints;

import com.chad.portfolio.pokerocket.model.Pokemon;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface PokeRocketEndpointsProxy {
    @POST
    @Path("/pokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer addPokemon(Pokemon pokemon);

    @GET
    @Path("/pokemon/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getPokemonById(@PathParam("id") Integer id);

    @GET
    @Path("/pokedex/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getPokemonByPokedexId(@PathParam("id") Integer pokedexId);

}

