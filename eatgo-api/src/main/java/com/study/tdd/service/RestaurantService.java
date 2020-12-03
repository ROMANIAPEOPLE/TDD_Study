package com.study.tdd.service;

import com.study.tdd.domain.MenuItem;
import com.study.tdd.domain.MenuItemRepository;
import com.study.tdd.domain.Restaurant;
import com.study.tdd.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
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

    @Transactional
    public Restaurant updateRestaurant(long id, String name, String address) {
        //TODO :: 레스토랑 업데이트하기.

        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(name, address);
//        restaurant.setName(name);
//        restaurant.setAddress(address);
        return restaurant;


    }
}
