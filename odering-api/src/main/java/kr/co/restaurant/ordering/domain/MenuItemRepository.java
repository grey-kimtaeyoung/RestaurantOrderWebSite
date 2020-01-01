package kr.co.restaurant.ordering.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
  List<MenuItem> findAllByRestaurantId(Long restaurantId);
}
