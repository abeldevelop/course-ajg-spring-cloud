package com.abeldevelop.course.ajgspringcloud.item.mapper;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product.ClientProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.item.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public Product mapClientToDomain(ClientProductResponseResource clientProductResponseResource) {
    return Product.builder()
        .id(clientProductResponseResource.getId())
        .name(clientProductResponseResource.getName())
        .price(clientProductResponseResource.getPrice())
        .createAt(clientProductResponseResource.getCreateAt())
        .build();
  }

  public ProductResponseResource mapDomainToResource(Product product) {
    return ProductResponseResource.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .createAt(product.getCreateAt())
        .build();
  }
}
