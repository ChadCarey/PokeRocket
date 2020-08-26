package com.chad.portfolio.pokerocket.model;

import java.util.Map;

public class Pokemon {
    private Integer id;
    private String name;
    private Integer height;
    private Map<String, String> sprites;
    private Integer weight;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

    private Integer hunger;
    private Integer age;

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

    public Map<String, String> getSprites() {
        return sprites;
    }

    public void setSprites(Map<String, String> sprites) {
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

    public Integer getHunger() {
        return hunger;
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Pokemon id(Integer id) {
        this.id = id;
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

    public Pokemon sprites(Map<String,String> sprites) {
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

    public Pokemon hunger(Integer hunger) {
        this.hunger = hunger;
        return this;
    }

    public Pokemon age(Integer age) {
        this.age = age;
        return this;
    }


}
