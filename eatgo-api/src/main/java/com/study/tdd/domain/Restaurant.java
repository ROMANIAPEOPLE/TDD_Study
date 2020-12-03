package com.study.tdd.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @Transient
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



    public String information() {
        return name + " in " + address;
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

    public void updateInformation(String name, String address) {
        this.name=name;
        this.address=address;
    }
}
