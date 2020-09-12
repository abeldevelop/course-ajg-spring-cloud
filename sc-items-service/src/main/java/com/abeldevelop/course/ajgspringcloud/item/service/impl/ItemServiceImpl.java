package com.abeldevelop.course.ajgspringcloud.item.service.impl;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ItemResource;
import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ProductResource;
import com.abeldevelop.course.ajgspringcloud.item.client.ProductsServiceFeignClient;
import com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product.ClientProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.item.mapper.ProductMapper;
import com.abeldevelop.course.ajgspringcloud.item.service.ItemService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

  private final ProductsServiceFeignClient productsServiceFeignClient;
  private final RestTemplate restTemplate;
  private final ProductMapper productMapper;

  @Override
  public List<ItemResource> findAll() {
    List<ClientProductResponseResource> products = findAllByFeignClient();
    return products
        .stream()
        .map(productMapper::map)
        .map(product -> ItemResource.builder().product(product).amount(1).build())
        .collect(Collectors.toList());
  }

  private List<ClientProductResponseResource> findAllByRestTemplate() {
    return Arrays.asList(
        restTemplate.getForObject("http://localhost:8001", ClientProductResponseResource[].class));
  }

  private List<ClientProductResponseResource> findAllByFeignClient() {
    return productsServiceFeignClient.findAll();
  }

  @Override
  public ItemResource findById(Long id, Integer amount) {

    Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("id", String.valueOf(id));

    return ItemResource.builder()
        .product(productMapper.map(productsServiceFeignClient.findById(id)))
        .amount(amount)
        .build();
  }

  @Override
  public ProductResource create(ProductResource productResource) {
    return productMapper.map(productsServiceFeignClient.create(productMapper.map(productResource)));
  }

  @Override
  public ProductResource update(Long id, ProductResource productResource) {
    return productMapper.map(
        productsServiceFeignClient.update(id, productMapper.map(productResource)));
  }

  @Override
  public void delete(Long id) {
    productsServiceFeignClient.deleteById(id);
  }
}
