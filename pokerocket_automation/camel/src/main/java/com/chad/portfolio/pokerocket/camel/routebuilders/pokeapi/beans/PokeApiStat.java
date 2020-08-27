package com.chad.portfolio.pokerocket.camel.routebuilders.pokeapi.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PokeApiStat {
    @JsonProperty
    private Integer base_stat;
    @JsonProperty
    private Integer effort;
    @JsonProperty
    private Map<String, String> stat;

    public Integer getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(Integer base_stat) {
        this.base_stat = base_stat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Map<String, String> getStat() {
        return stat;
    }

    public void setStat(Map<String, String> stat) {
        this.stat = stat;
    }
}
