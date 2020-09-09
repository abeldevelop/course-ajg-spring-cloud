package com.abeldevelop.course.ajgspringcloud.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Item {

  private Product product;
  private Integer amount;

  public Double getTotal() {
    return product.getPrice() * amount.doubleValue();
  }
}
