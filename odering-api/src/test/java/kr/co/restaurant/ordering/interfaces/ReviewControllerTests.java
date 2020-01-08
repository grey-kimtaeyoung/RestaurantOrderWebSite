package kr.co.restaurant.ordering.interfaces;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kr.co.restaurant.ordering.application.ReviewService;
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
  public void create() throws Exception {
    mvc.perform(post("/restaurants/1/reviews")
    .contentType(MediaType.APPLICATION_JSON)
    .content("{\"name\":\"taeyoung\", \"score\": 4, \"desc\": \"good\"}"))
        .andExpect(status().isCreated());

    verify(reviewService).addReview(any());
  }

}