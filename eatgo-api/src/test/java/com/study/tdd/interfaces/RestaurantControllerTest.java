package com.study.tdd.interfaces;

import com.study.tdd.domain.*;
import com.study.tdd.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {


    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @BeforeEach
    void BeforeEach() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).alwaysDo(print()).build();
    }

    @MockBean
    private RestaurantService restaurantService;


    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "\"id\":1004")
                ));

    }

    @Test
    public void detail() throws Exception {

        Restaurant restaurant1 = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurant1.addMenu(new MenuItem("Kimchi"));
        Restaurant restaurant2 = new Restaurant(2020L, "Bob zip", "Seoul");
        restaurant1.addMenu(new MenuItem("Kimchi"));
        given(restaurantService.getRestaurantById(1004L)).willReturn(restaurant1);
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "\"id\":1004"
                )))
                .andExpect(content().string(containsString(
                        "\"name\":\"Bob zip\""
                )))
                .andExpect(content().string(containsString(
                        "Kimchi"
                )));

        given(restaurantService.getRestaurantById(2020L)).willReturn(restaurant2);
        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "\"id\":2020"
                )));

    }

    @Test
    public void create() throws Exception {


        mvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\" : \"KH\", \"address\" :\"Seoul\"}\n"))

                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1234"))
                .andExpect(content().string("{}"));


        verify(restaurantService).addRestaurant(any());

    }


}