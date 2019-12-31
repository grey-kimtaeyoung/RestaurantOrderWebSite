package kr.co.restaurant.ordering.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kr.co.restaurant.ordering.application.RestaurantService;
import kr.co.restaurant.ordering.domain.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/restaurants")
  public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
    String name = "BeRyong";
    String address = "Busan";

    Restaurant restaurant = new Restaurant(1234L, name, address);
    restaurantService.addRestaurant(restaurant);

    URI location = new URI("/restaurants/" + restaurant.getId());
    return ResponseEntity.created(location).body("{}");
  }

}
