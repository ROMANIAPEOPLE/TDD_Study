package com.study.tdd.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long id);
}
