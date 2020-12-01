package com.study.tdd.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MenuItemRepositoryImpl implements MenuItemRepository {
   private List<MenuItem> list = new ArrayList<>();

   public MenuItemRepositoryImpl(){
       list.add(new MenuItem("Kimchi"));
   }

    @Override
    public List<MenuItem> findAllByRestaurantId(Long id) {

        return list;
    }
}
