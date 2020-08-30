package com.chad.portfolio.pokerocket.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private Integer pokedexId;
    @JsonProperty
    private String name;
    @JsonProperty
    private Integer height;
    @JsonProperty
    private String sprites;
    @JsonProperty
    private Integer weight;
    @JsonProperty
    private Integer hp;
    @JsonProperty
    private Integer attack;
    @JsonProperty
    private Integer defense;
    @JsonProperty
    private Integer specialAttack;
    @JsonProperty
    private Integer specialDefense;
    @JsonProperty
    private Integer speed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
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

    public String getSprites() {
        return sprites;
    }

    public void setSprites(String sprites) {
        this.sprites = sprites;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Pokemon id(Integer id) {
        this.id = id;
        return this;
    }

    public Pokemon pokedexId(Integer id) {
        this.pokedexId = id;
        return this;
    }

    public Pokemon name(String name) {
        this.name = name;
        return this;
    }

    public Pokemon height(Integer height) {
        this.height = height;
        return this;
    }

    public Pokemon sprites(String sprites) {
        this.sprites = sprites;
        return this;
    }

    public Pokemon weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Pokemon hp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public Pokemon attack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public Pokemon defense(Integer defense) {
        this.defense = defense;
        return this;
    }

    public Pokemon specialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
        return this;
    }

    public Pokemon specialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
        return this;
    }

    public Pokemon speed(Integer speed) {
        this.speed = speed;
        return this;
    }


}
