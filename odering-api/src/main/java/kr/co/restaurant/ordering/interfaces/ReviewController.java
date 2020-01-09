package kr.co.restaurant.ordering.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;
import kr.co.restaurant.ordering.application.ReviewService;
import kr.co.restaurant.ordering.domain.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

  private ReviewService reviewService;

  ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @PostMapping("/restaurants/{restaurantId}/reviews")
  public ResponseEntity<?> create(
      @PathVariable("restaurantId") Long restaurantId,
      @Valid @RequestBody Review resource
  ) throws URISyntaxException {
    Review review = reviewService.addReview(resource);
    String url = "/restaurants/" + restaurantId +
        "/reviews/" + review.getId();
    return ResponseEntity.created(new URI(url)).body("{}");
  }

}
