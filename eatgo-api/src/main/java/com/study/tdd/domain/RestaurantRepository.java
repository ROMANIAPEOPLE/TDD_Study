package com.study.tdd.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);
}
