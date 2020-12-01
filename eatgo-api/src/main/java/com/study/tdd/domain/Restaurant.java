package com.study.tdd.domain;

import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Restaurant {
    private String name;
    private String address;
    private Long id;
    private List<MenuItem> menuItems = new ArrayList<>();




    public Restaurant(Long id, String name, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public Restaurant(String name, String address) {
        this.name=name;
        this.address=address;

    }

    public String getAddress() {
        return address;
    }


    public String getName() {
        return name;
    }

    public String information() {
        return name + " in " + address;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenu(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            addMenu(menuItem);
        }
    }
}
