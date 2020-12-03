package com.study.tdd.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuItemRepository extends CrudRepository<MenuItem,Long> {
    List<MenuItem> findAllByRestaurantId(Long id);
}
