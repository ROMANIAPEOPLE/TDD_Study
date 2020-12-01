package com.study.tdd.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryImplTest {


    @Test
    public void save () {
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
        int oldCount = restaurantRepository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong","Seoul");

        restaurantRepository.save(restaurant);
        assertThat(restaurant.getId()).isEqualTo(1234L);
        int newCount = restaurantRepository.findAll().size();
        assertThat(newCount-oldCount).isEqualTo(1);
    }

}