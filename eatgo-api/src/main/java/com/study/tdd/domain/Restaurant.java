package com.study.tdd.domain;

public class Restaurant {
    private final String name;
    private final String address;

    public Restaurant(String name,String address) {
        this.name=name;
        this.address=address;
    }

    public String getAddress(){
        return address;
    }


    public String getName() {
        return name;
    }

    public String information(){
        return name + " ln " + address;
    }


}
