package kr.co.restaurant.ordering.interfaces;

import java.util.List;
import kr.co.restaurant.ordering.application.MenuItemService;
import kr.co.restaurant.ordering.domain.MenuItem;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuItemController {

  private final MenuItemService menuItemService;

  public MenuItemController(MenuItemService menuItemService) {
    this.menuItemService = menuItemService;
  }

  @PatchMapping("/restaurants/{restaurantId}/menuitems")
  public String bulkUpdate(
      @PathVariable("restaurantId") Long restaurantId,
      @RequestBody List<MenuItem> menuItems
  ) {
    menuItemService.bulkUpdate(restaurantId, menuItems);

    return "";
  }
}
