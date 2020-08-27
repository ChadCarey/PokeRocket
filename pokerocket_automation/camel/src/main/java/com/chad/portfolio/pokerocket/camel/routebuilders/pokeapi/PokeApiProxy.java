package com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi;

import com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi.beans.PokeApiPokemon;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;

public interface PokeApiProxy {
//    @GET
//    @Path("/pokemon/{name}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPokemonByName(@PathParam("name") String name);

    @GET
    @Path("/pokemon/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PokeApiPokemon getPokemonById(@PathParam("id") Integer id);

}

