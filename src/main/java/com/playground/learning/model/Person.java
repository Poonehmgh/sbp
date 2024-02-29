package com.playground.learning.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    private final UUID id;
    private final String name;


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
