package com.abeldevelop.course.ajgspringcloud.item.service;

import com.abeldevelop.course.ajgspringcloud.item.domain.Item;
import java.util.List;

public interface ItemService {

  List<Item> findAll();

  Item findById(Long id, Integer amount);
}
