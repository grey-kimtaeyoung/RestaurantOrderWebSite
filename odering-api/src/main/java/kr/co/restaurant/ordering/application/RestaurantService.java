package kr.co.restaurant.ordering.application;

import java.util.List;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import kr.co.restaurant.ordering.domain.Restaurant;
import kr.co.restaurant.ordering.domain.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
  private final RestaurantRepository restaurantRepository;
  private final MenuItemRepository menuItemRepository;

  public RestaurantService(
      RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
    this.restaurantRepository = restaurantRepository;
    this.menuItemRepository = menuItemRepository;
  }

  public List<Restaurant> getRestaurants() {
    return restaurantRepository.findAll();
  }

  public Restaurant getRestaurant(Long id) {
    Restaurant restaurant = restaurantRepository.findById(id);

    List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
    restaurant.setMenuItems(menuItems);

    return restaurant;
  }

  public Restaurant addRestaurant(Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }
}
