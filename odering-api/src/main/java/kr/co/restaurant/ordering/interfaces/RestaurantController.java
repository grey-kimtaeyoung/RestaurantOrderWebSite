package kr.co.restaurant.ordering.interfaces;

import java.util.List;
import kr.co.restaurant.ordering.application.RestaurantService;
import kr.co.restaurant.ordering.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  private final RestaurantService restaurantService;

  public RestaurantController(
      RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @GetMapping("/restaurants")
  public List<Restaurant> list() {
    return restaurantService.getRestaurants();
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail(
      @PathVariable("id") Long id
  ) {
    return restaurantService.getRestaurant(id);
  }

}
