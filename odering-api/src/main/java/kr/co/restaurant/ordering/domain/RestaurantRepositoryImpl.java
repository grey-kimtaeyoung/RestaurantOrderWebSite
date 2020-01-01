package kr.co.restaurant.ordering.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

  private List<Restaurant> restaurants = new ArrayList<>();

  public RestaurantRepositoryImpl() {
    restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
    restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
  }

  @Override
  public List<Restaurant> findAll() {
    return restaurants;
  }

  @Override
  public Restaurant findById(Long id) {
    Restaurant restaurant;
    restaurant = restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);

    return restaurant;
  }

  @Override
  public Restaurant save(Restaurant restaurant) {
    restaurant.setId(1234L);
    restaurants.add(restaurant);
    return restaurant;
  }
}
