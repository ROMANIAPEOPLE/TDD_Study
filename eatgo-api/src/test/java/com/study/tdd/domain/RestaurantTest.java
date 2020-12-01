package com.study.tdd.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RestaurantTest {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant(1004L,"bab","");
        assertThat(restaurant.getName()).isEqualTo("bab");
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L,"kh","Seoul");
        assertThat(restaurant.information()).isEqualTo("kh in Seoul");
        assertThat(restaurant.getId()).isEqualTo(1004L);
    }

}