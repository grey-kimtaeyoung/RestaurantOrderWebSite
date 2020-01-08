package kr.co.restaurant.ordering.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import kr.co.restaurant.ordering.application.ReviewService;
import kr.co.restaurant.ordering.domain.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {


  private ReviewService reviewService;

  ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @PostMapping("/restaurants/{restaurantId}/reviews")
  public ResponseEntity<?> create() throws URISyntaxException {
    Review review = Review.builder().build();
    reviewService.addReview(review);
    return ResponseEntity.created(new URI("/restaurants/1/reviews/1")).body("{}");
  }

}
