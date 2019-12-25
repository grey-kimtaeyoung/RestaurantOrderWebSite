package kr.co.restaurant.ordering.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@SpringBootTest
class RestaurantJavaTests {

  @Test
  public void creation() {
    Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
    assertThat(restaurant.getName(), is("Bob zip"));
    assertThat(restaurant.getAddress(), is("Seoul"));
  }

  @Test
  public void information() {
    Restaurant restaurant = new Restaurant("Bob zip", "Seoul");

    assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
  }

}