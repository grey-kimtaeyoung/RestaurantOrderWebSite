package kr.co.restaurant.ordering.application;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import kr.co.restaurant.ordering.domain.Restaurant;
import kr.co.restaurant.ordering.domain.RestaurantRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RestaurantServiceTest {

  private RestaurantService restaurantService;
  @Mock
  private RestaurantRepository restaurantRepository;
  @Mock
  private MenuItemRepository menuItemRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    mockRestaurantRepository();
    mockMenuItemRepository();

    restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
  }

  private void mockRestaurantRepository() {
    List<Restaurant> restaurants = new ArrayList<>();
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
    restaurants.add(restaurant);
    given(restaurantRepository.findAll()).willReturn(restaurants);

    given(restaurantRepository.findById(1004L)).willReturn(restaurant);
  }

  private void mockMenuItemRepository() {
    List<MenuItem> menuItems = new ArrayList<>();
    menuItems.add(new MenuItem("Kimchi"));
    given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
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