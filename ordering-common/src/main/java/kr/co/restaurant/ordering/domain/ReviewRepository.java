package kr.co.restaurant.ordering.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  List<Review> findAllByRestaurantId(long restaurantId);

  Review save(Review review);
}
