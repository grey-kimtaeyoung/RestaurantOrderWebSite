package kr.co.restaurant.ordering.interfaces;

import java.util.List;
import kr.co.restaurant.ordering.domain.Restaurant;
import kr.co.restaurant.ordering.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  @Autowired
  private RestaurantRepository repository;

  @GetMapping("/restaurants")
  public List<Restaurant> list() {

    List<Restaurant> restaurants = repository.findAll();
    return restaurants;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail(
      @PathVariable("id") Long id
  ) {
    Restaurant restaurant = repository.findById(id);

    return restaurant;
  }

}
