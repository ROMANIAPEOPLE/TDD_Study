package com.study.tdd.service;

import com.study.tdd.domain.MenuItem;
import com.study.tdd.domain.MenuItemRepository;
import com.study.tdd.domain.Restaurant;
import com.study.tdd.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private   RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;



    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository =restaurantRepository;
        this.menuItemRepository  = menuItemRepository;
    }

    public Restaurant getRestaurantById(Long id){
        Restaurant restaurant = restaurantRepository.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItem(menuItems);
        return restaurant;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();

    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
