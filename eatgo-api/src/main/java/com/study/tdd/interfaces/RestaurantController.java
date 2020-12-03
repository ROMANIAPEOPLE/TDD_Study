package com.study.tdd.interfaces;

import com.study.tdd.domain.MenuItem;
import com.study.tdd.domain.MenuItemRepository;
import com.study.tdd.domain.Restaurant;
import com.study.tdd.domain.RestaurantRepository;
import com.study.tdd.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list (){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurantById(id);

        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
        String name =resource.getName();
        String address =resource.getAddress();
        Restaurant restaurant = new Restaurant(name,address);
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("restaurants/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Restaurant resource){
        String name = resource.getName();
        String address = resource.getAddress();
        restaurantService.updateRestaurant(id,name,address);
        return "{}";
    }

}
