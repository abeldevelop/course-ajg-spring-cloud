package com.abeldevelop.course.ajgspringcloud.products.service.impl;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResource;
import com.abeldevelop.course.ajgspringcloud.products.exception.NotFoundException;
import com.abeldevelop.course.ajgspringcloud.products.mapper.ProductMapper;
import com.abeldevelop.course.ajgspringcloud.products.model.ProductEntity;
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
  public List<ProductResource> findAll() {
    return productRepository
        .findAll()
        .stream()
        .map(productMapper::map)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  @Override
  public ProductResource findById(Long id) {
    return productMapper.map(find(id));
  }

  @Transactional
  @Override
  public ProductResource create(ProductResource productResource) {
    return productMapper.map(productRepository.save(productMapper.map((productResource))));
  }

  @Override
  public ProductResource update(Long id, ProductResource productResource) {
    ProductEntity productEntity = find(id);
    productEntity.setName(productResource.getName());
    productEntity.setPrice(productResource.getPrice());
    return productMapper.map(productRepository.save(productEntity));
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    ProductEntity productEntity = find(id);
    productRepository.delete(productEntity);
  }

  private ProductEntity find(Long id) {
    return productRepository
        .findById(id)
        .orElseThrow(
            () -> {
              log.warn("No exist Product with ID: {}", id);
              return new NotFoundException("Product Not Found");
            });
  }
}
