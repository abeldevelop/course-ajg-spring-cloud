package com.abeldevelop.course.ajgspringcloud.item.mapper;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ItemResponseResource;
import com.abeldevelop.course.ajgspringcloud.item.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ItemMapper {

  private final ProductMapper productMapper;

  public ItemResponseResource mapDomainToResource(Item item) {
    return ItemResponseResource.builder()
        .product(productMapper.mapDomainToResource(item.getProduct()))
        .amount(item.getAmount())
        .total(item.getTotal())
        .build();
  }
}
