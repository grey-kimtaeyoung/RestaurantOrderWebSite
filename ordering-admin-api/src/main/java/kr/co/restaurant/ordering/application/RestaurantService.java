package kr.co.restaurant.ordering.application;

import java.util.List;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import kr.co.restaurant.ordering.domain.Restaurant;
import kr.co.restaurant.ordering.domain.RestaurantNotFoundException;
import kr.co.restaurant.ordering.domain.RestaurantRepository;
import kr.co.restaurant.ordering.domain.Review;
import kr.co.restaurant.ordering.domain.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {
  private final RestaurantRepository restaurantRepository;

  public RestaurantService(
      RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  public List<Restaurant> getRestaurants() {
    return restaurantRepository.findAll();
  }

  public Restaurant getRestaurant(Long id) {
    Restaurant restaurant =
        restaurantRepository.findById(id).orElseThrow(
            () -> new RestaurantNotFoundException(id));

    return restaurant;
  }

  public Restaurant addRestaurant(Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }

  @Transactional
  public Restaurant updateRestaurant(Long id, String name, String address) {
    Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

    restaurant.updateInformation(name, address);

    return restaurant;
  }
}
