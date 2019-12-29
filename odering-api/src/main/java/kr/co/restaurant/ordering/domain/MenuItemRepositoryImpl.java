package kr.co.restaurant.ordering.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository{
  List<MenuItem> menuItems = new ArrayList<>();

  public MenuItemRepositoryImpl() {
    menuItems.add(new MenuItem("Kimchi"));
  }

  @Override
  public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
    return menuItems;
  }
}
