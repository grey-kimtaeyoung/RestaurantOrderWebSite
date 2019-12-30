package kr.co.restaurant.ordering.interfaces;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import kr.co.restaurant.ordering.application.RestaurantService;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import kr.co.restaurant.ordering.domain.MenuItemRepositoryImpl;
import kr.co.restaurant.ordering.domain.Restaurant;
import kr.co.restaurant.ordering.domain.RestaurantRepository;
import kr.co.restaurant.ordering.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private RestaurantService restaurantService;

  @Test
  public void list() throws Exception {
    List<Restaurant> restaurants = new ArrayList<>();
    restaurants.add(new Restaurant(1004L, "JOKER House", "Seoul"));
    given(restaurantService.getRestaurants()).willReturn(restaurants);

    mvc.perform(get("/restaurants"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":1004")))
        .andExpect(content().string(containsString("\"name\":\"JOKER House\"")))
        .andExpect(content().string(containsString("\"address\":\"Seoul\"")))
        .andExpect(content().string(containsString("\"information\":\"Bob zip in Seoul\"")));
  }

  @Test
  public void detail() throws Exception {
    Restaurant restaurant1 = new Restaurant(1004L, "JOKER House", "Seoul");
    restaurant1.addMenuItem(new MenuItem("Kimchi"));
    given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);

    Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food", "Seoul");
    given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

    mvc.perform(get("/restaurants/1004"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":1004")
        ))
        .andExpect(content().string(containsString("\"name\":\"JOKER House\"")
        ))
        .andExpect(content().string(
            containsString("Kimchi")
        ));

    mvc.perform(get("/restaurants/2020"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"id\":2020")))
        .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
  }
}