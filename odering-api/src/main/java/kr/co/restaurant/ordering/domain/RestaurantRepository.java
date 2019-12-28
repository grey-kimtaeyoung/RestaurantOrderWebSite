package kr.co.restaurant.ordering.domain;

import java.util.List;

public interface RestaurantRepository {

  List<Restaurant> findAll();

  Restaurant findById(Long id);
}
