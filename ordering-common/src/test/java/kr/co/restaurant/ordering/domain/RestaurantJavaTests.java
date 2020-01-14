package kr.co.restaurant.ordering.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RestaurantJavaTests {

  @Test
  public void creation() {
    Restaurant restaurant = Restaurant.builder()
        .id(1004L)
        .name("Bob zip")
        .address("Seoul")
        .build();

    assertThat(restaurant.getId(), is(1004L));
    assertThat(restaurant.getName(), is("Bob zip"));
    assertThat(restaurant.getAddress(), is("Seoul"));
  }

  @Test
  public void information() {
    Restaurant restaurant = Restaurant.builder()
        .id(1004L)
        .name("Bob zip")
        .address("Seoul")
        .build();

    assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
  }

}