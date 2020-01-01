package kr.co.restaurant.ordering.domain;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@SpringBootTest
class RestaurantJavaTests {

  @Test
  public void creation() {
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

    assertThat(restaurant.getId(), is(1004L));
    assertThat(restaurant.getName(), is("Bob zip"));
    assertThat(restaurant.getAddress(), is("Seoul"));
  }

  @Test
  public void information() {
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

    assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
  }

}