package com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product;

import java.io.Serializable;
import java.time.LocalDate;
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
public class ClientProductResponseResource implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Double price;
  private LocalDate createAt;
}
