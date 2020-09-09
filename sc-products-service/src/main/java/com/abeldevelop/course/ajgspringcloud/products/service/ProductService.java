package com.abeldevelop.course.ajgspringcloud.products.service;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResponseResource;
import java.util.List;

public interface ProductService {

  List<ProductResponseResource> findAll();

  ProductResponseResource findById(Long id);
}
