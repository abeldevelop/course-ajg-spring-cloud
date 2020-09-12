package com.abeldevelop.course.ajgspringcloud.products.service;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResource;
import java.util.List;

public interface ProductService {

  List<ProductResource> findAll();

  ProductResource findById(Long id);

  ProductResource create(ProductResource productResource);

  ProductResource update(Long id, ProductResource productResource);

  void deleteById(Long id);
}
