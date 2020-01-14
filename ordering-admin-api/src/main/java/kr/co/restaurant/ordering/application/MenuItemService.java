package kr.co.restaurant.ordering.application;

import java.util.ArrayList;
import java.util.List;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

  private MenuItemRepository menuItemRepository;

  public MenuItemService(
      MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;
  }

  public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
    for (MenuItem menuItem : menuItems) {
      update(restaurantId, menuItem);
    }
  }

  private void update(Long restaurantId, MenuItem menuItem) {
    if(menuItem.isDestroy()) {
      menuItemRepository.deleteById(menuItem.getId());
      return;
    }

    menuItem.setRestaurantId(restaurantId);
    menuItemRepository.save(menuItem);
  }
}
