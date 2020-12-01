package com.study.tdd.domain;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);
}
