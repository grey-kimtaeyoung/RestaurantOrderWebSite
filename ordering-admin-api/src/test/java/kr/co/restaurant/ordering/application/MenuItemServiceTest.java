package kr.co.restaurant.ordering.application;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import kr.co.restaurant.ordering.domain.MenuItem;
import kr.co.restaurant.ordering.domain.MenuItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MenuItemServiceTest {

  private MenuItemService menuItemService;

  @Mock
  private MenuItemRepository menuItemRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    menuItemService = new MenuItemService(menuItemRepository);
  }

  @Test
  public void getMenuItems() {
    List<MenuItem> mockMenuItems = new ArrayList<>();
    mockMenuItems.add(MenuItem.builder().name("Kimchi").build());

    given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(mockMenuItems);

    List<MenuItem> menuItems = menuItemService.getMenuItems(1004L);

    MenuItem menuItem = mockMenuItems.get(0);

    assertThat(menuItem.getName(), is("Kimchi"));
  }

  @Test
  public void bulkUpdate() {
    List<MenuItem> menuItems = new ArrayList<>();
    
    menuItems.add(MenuItem.builder()
        .name("Kimchi")
        .build());

    menuItems.add(MenuItem.builder()
        .id(12L)
        .name("Gukbob")
        .build());

    menuItems.add(MenuItem.builder()
        .id(1004L).destroy(true)
        .build());

    menuItemService.bulkUpdate(1L, menuItems);

    /**
     * times
     * 테스트를 몇번 수행시킬지 결정하는 함수
     * 위에 'Kimchi'와 'Gukbob' 두 개를 저장해야하므로 times를 1로 바꾸면 오류발생
     */
    verify(menuItemRepository, times(2)).save(any());
    verify(menuItemRepository, times(1)).deleteById(eq(1004L));
  }
}