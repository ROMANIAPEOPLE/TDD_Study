package com.study.tdd.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    private final String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
