package kr.co.restaurant.ordering.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

  @Id
  @GeneratedValue
  @Setter
  private Long id;

  @NotEmpty
  private String name;

  @NotEmpty
  private String address;

  @Transient
  /**
   @JsonInclude(Include.NON_NULL)
   null 데이터는 반환하지 않도록 처리
   json을 더 깔끔하게 확인 할 수 있다.
   */
  @JsonInclude(Include.NON_NULL)
  private List<MenuItem> menuItems;

  public String getInformation() {
    return name + " in " + address;
  }

  public void setMenuItems(List<MenuItem> menuItems) {
    this.menuItems = new ArrayList<>(menuItems);
  }

  public void updateInformation(String name, String address) {
    this.name = name;
    this.address = address;
  }
}
