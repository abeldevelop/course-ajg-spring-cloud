package com.abeldevelop.course.ajgspringcloud.item.service;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ItemResource;
import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ProductResource;
import java.util.List;

public interface ItemService {

  List<ItemResource> findAll();

  ItemResource findById(Long id, Integer amount);

  ProductResource create(ProductResource productResource);

  ProductResource update(Long id, ProductResource productResource);

  void delete(Long id);
}
