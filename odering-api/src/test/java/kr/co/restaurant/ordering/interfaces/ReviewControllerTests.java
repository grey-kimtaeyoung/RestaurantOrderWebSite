package kr.co.restaurant.ordering.interfaces;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kr.co.restaurant.ordering.application.ReviewService;
import kr.co.restaurant.ordering.domain.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTests {

  @Autowired
  MockMvc mvc;

  @MockBean
  private ReviewService reviewService;

  @Test
  public void createWithValidAttriutes() throws Exception {
    given(reviewService.addReview(any())).willReturn(
        Review.builder().id(123L)
            .name("taeyoung")
            .score(3)
            .desc("good").build()
    );

    mvc.perform(
            post("/restaurants/1/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"name\":\"taeyoung\", \"score\": 4, \"desc\": \"good\"}"))
        .andExpect(status().isCreated())
        .andExpect(header().string("location", "/restaurants/1/reviews/123"));

    verify(reviewService).addReview(any());
  }

  @Test
  public void createWithInvalidAttriutes() throws Exception {
    mvc.perform(
        post("/restaurants/1/reviews")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{}"))
        .andExpect(status().isBadRequest());

    verify(reviewService, never()).addReview(any());
  }


}