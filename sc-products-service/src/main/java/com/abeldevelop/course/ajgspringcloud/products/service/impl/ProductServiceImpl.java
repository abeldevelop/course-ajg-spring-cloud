package com.abeldevelop.course.ajgspringcloud.products.service.impl;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.products.exception.NotFoundException;
import com.abeldevelop.course.ajgspringcloud.products.mapper.ProductMapper;
import com.abeldevelop.course.ajgspringcloud.products.repository.ProductRepository;
import com.abeldevelop.course.ajgspringcloud.products.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  @Transactional(readOnly = true)
  @Override
  public List<ProductResponseResource> findAll() {
    return productRepository
        .findAll()
        .stream()
        .map(productMapper::mapEntityToResource)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  @Override
  public ProductResponseResource findById(Long id) {
    return productMapper.mapEntityToResource(
        productRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  log.warn("No exist Product with ID: {}", id);
                  return new NotFoundException("Product Not Found");
                }));
  }
}
