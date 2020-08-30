package com.chad.portfolio.pokerocket.clients.pokeapi.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeApiPokemon {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Integer height;
    // @JsonProperty
    // private Map<String, Map<String,String> > sprites;
    @JsonProperty
    private Integer weight;
    @JsonProperty
    private List<PokeApiStat> stats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    // public Map<String, Map<String,String> > getSprites() {
    //     return sprites;
    // }

    // public void setSprites(Map<String, Map<String,String> > sprites) {
    //     this.sprites = sprites;
    // }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<PokeApiStat> getStats() {
        return stats;
    }

    public void setStats(List<PokeApiStat> stats) {
        this.stats = stats;
    }
}
