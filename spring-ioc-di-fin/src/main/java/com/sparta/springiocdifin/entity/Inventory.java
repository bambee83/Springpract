package com.sparta.springiocdifin.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ingredient;
    private int amount;

    public Inventory() {}

    public Inventory(String ingredient, int amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }
}

