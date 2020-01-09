package kr.co.restaurant.ordering.application;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import kr.co.restaurant.ordering.domain.Review;
import kr.co.restaurant.ordering.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReviewServiceTests {

  private ReviewService reviewService;

  @Mock
  private ReviewRepository reviewRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    reviewService = new ReviewService(reviewRepository);
  }

  @Test
  public void addReview() {
    Review review = Review.builder()
        .name("taeyoung")
        .score(3)
        .desc("good")
        .build();

    reviewService.addReview(review);

    verify(reviewRepository).save(any());
  }
}