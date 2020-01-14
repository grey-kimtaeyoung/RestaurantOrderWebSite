package kr.co.restaurant.ordering.application;

import kr.co.restaurant.ordering.domain.Review;
import kr.co.restaurant.ordering.domain.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

  private ReviewRepository reviewRepository;

  public ReviewService(ReviewRepository reviewRepository){
    this.reviewRepository = reviewRepository;
  }

  public Review addReview(Long restaurantId, Review review) {
    review.setRestaurantId(restaurantId);
    return reviewRepository.save(review);
  }
}
