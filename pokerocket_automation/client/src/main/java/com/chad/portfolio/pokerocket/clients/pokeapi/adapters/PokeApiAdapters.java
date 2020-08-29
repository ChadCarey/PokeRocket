package com.chad.portfolio.pokerocket.clients.pokeapi.adapters;

import com.chad.portfolio.pokerocket.clients.pokeapi.beans.PokeApiPokemon;
import com.chad.portfolio.pokerocket.clients.pokeapi.beans.PokeApiStat;
import com.chad.portfolio.pokerocket.model.Pokemon;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PokeApiAdapters {
   public static Pokemon FromPokeApi(PokeApiPokemon pokeApiPokemon) throws Exception {
            Pokemon pokemon = new Pokemon();

            for(PokeApiStat stat : pokeApiPokemon.getStats()) {
                String statName = stat.getStat().getOrDefault("name", "None");
                switch(statName) {
                    case "hp":
                        pokemon.hp(stat.getBase_stat());
                        break;
                    case "attack":
                        pokemon.attack(stat.getBase_stat());
                        break;
                    case "defense":
                        pokemon.defense(stat.getBase_stat());
                        break;
                    case "special-attack":
                        pokemon.specialAttack(stat.getBase_stat());
                        break;
                    case "special-defense":
                        pokemon.specialDefense(stat.getBase_stat());
                        break;
                    case "speed":
                        pokemon.speed(stat.getBase_stat());
                        break;
                    default:
                        throw new Exception("Unknown PokeApiStatType: " + statName);
                }
            }

            Map<String, String> sprites = new HashMap<>();
            // Map<String, ?> pokeApiSprites = pokeApiPokemon.getSprites();
            // for(String key : pokeApiSprites.keySet()) {
            //     Optional.ofNullable(pokeApiSprites.get(key))
            //             .ifPresent(spriteUrl -> sprites.put(key, (String)spriteUrl));
            // }

            pokemon
                    .pokedexId(pokeApiPokemon.getId())
                    .height(pokeApiPokemon.getHeight())
                    .sprites(sprites)
            ;

            return pokemon;
        }

}
