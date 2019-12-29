package kr.co.restaurant.ordering.application;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import kr.co.restaurant.ordering.domain.MenuItemRepositoryImpl;
import kr.co.restaurant.ordering.domain.Restaurant;
import kr.co.restaurant.ordering.domain.RestaurantRepository;
import kr.co.restaurant.ordering.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

public class RestaurantServiceTest {

  private RestaurantService restaurantService;
  private RestaurantRepository restaurantRepository;
  private MenuItemRepository menuItemRepository;

  @Before
  public void setUp() {
    restaurantRepository = new RestaurantRepositoryImpl();
    menuItemRepository = new MenuItemRepositoryImpl();
    restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
  }

  @Test
  public void getRestaurants() {
    List<Restaurant> restaurants = restaurantService.getRestaurants();

    Restaurant restaurant = restaurants.get(0);
    assertThat(restaurant.getId(), is(1004L));
  }

  @Test
  public void getRestaurant() {
    Restaurant restaurant = restaurantService.getRestaurant(1004L);
    assertThat(restaurant.getId(), is(1004L));

    MenuItem menuItem = restaurant.getMenuItems().get(0);
    assertThat(menuItem.getName(), is("Kimchi"));
  }
}