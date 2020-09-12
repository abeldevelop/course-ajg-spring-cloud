package com.abeldevelop.course.ajgspringcloud.products.mapper;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResource;
import com.abeldevelop.course.ajgspringcloud.products.model.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductResource map(ProductEntity productEntity) {
    return ProductResource.builder()
        .id(productEntity.getId())
        .name(productEntity.getName())
        .price(productEntity.getPrice())
        .createAt(productEntity.getCreateAt())
        .build();
  }

  public ProductEntity map(ProductResource productResource) {
    return ProductEntity.builder()
        .name(productResource.getName())
        .price(productResource.getPrice())
        .createAt(productResource.getCreateAt())
        .build();
  }
}
