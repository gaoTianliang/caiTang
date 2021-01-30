package com.code.net.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }
}
