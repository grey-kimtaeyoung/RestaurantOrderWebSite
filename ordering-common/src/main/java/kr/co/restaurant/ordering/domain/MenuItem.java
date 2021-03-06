package kr.co.restaurant.ordering.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
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
public class MenuItem {

  @Id
  @GeneratedValue
  private Long id;

  @Setter
  private Long restaurantId;

  private String name;

  @Transient
  @JsonInclude(Include.NON_DEFAULT)
  private boolean destroy;

}
