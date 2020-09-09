package com.abeldevelop.course.ajgspringcloud.item.service.impl;

import com.abeldevelop.course.ajgspringcloud.item.client.ProductsServiceFeignClient;
import com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product.ClientProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.item.domain.Item;
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
  public List<Item> findAll() {
    List<ClientProductResponseResource> products = findAllByFeignClient();
    return products
        .stream()
        .map(productMapper::mapClientToDomain)
        .map(product -> Item.builder().product(product).amount(1).build())
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
  public Item findById(Long id, Integer amount) {

    Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("id", String.valueOf(id));

    return Item.builder()
        .product(
            productMapper.mapClientToDomain(
                restTemplate.getForObject(
                    "http://localhost:8001/{id}",
                    ClientProductResponseResource.class,
                    pathVariables)))
        .amount(amount)
        .build();
  }
}
