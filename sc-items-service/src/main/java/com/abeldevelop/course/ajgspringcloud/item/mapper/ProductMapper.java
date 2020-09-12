package com.abeldevelop.course.ajgspringcloud.item.mapper;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ProductResource;
import com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product.ClientProductResponseResource;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ClientProductResponseResource map(ProductResource productResource) {
    return ClientProductResponseResource.builder()
        .id(productResource.getId())
        .name(productResource.getName())
        .price(productResource.getPrice())
        .createAt(productResource.getCreateAt())
        .build();
  }

  public ProductResource map(ClientProductResponseResource clientProductResponseResource) {
    return ProductResource.builder()
        .id(clientProductResponseResource.getId())
        .name(clientProductResponseResource.getName())
        .price(clientProductResponseResource.getPrice())
        .createAt(clientProductResponseResource.getCreateAt())
        .build();
  }
}
