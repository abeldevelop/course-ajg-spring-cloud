package com.abeldevelop.course.ajgspringcloud.products.mapper;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.products.model.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductResponseResource mapEntityToResource(ProductEntity productEntity) {
    return ProductResponseResource.builder()
        .id(productEntity.getId())
        .name(productEntity.getName())
        .price(productEntity.getPrice())
        .createAt(productEntity.getCreateAt())
        .build();
  }
}
