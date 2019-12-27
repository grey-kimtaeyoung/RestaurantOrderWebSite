package kr.co.restaurant.ordering.interfaces;

import java.util.ArrayList;
import java.util.List;
import kr.co.restaurant.ordering.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  @GetMapping("/restaurants")
  public List<Restaurant> list() {
    List<Restaurant> restaurants = new ArrayList<>();
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

    restaurants.add(restaurant);

    return restaurants;
  }

}
