package kr.co.restaurant.ordering.interfaces;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuItemController.class)
public class MenuItemControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void bulkUpdate() throws Exception {
    mvc.perform(patch("/restaurans/1/menuitems"))
        .andExpect();
  }

}