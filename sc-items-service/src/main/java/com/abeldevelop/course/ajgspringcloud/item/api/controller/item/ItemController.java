package com.abeldevelop.course.ajgspringcloud.item.api.controller.item;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ItemResponseResource;
import com.abeldevelop.course.ajgspringcloud.item.mapper.ItemMapper;
import com.abeldevelop.course.ajgspringcloud.item.service.ItemService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RequiredArgsConstructor
@RestController
public class ItemController {

  private final ItemService itemService;
  private final ItemMapper itemMapper;

  @Value("${configuracion.texto}")
  private String configuracionTexto;

  @GetMapping
  public List<ItemResponseResource> findAll() {
    System.out.println(configuracionTexto);

    log.info("ItemController.findAll Data IN => empty");
    List<ItemResponseResource> response =
        itemService
            .findAll()
            .stream()
            .map(itemMapper::mapDomainToResource)
            .collect(Collectors.toList());
    log.info("ItemController.findAll Data OUT => size: {}", response.size());
    return response;
  }

  @GetMapping("/{id}/amount/{amount}")
  public ItemResponseResource detail(@PathVariable Long id, @PathVariable Integer amount) {
    log.info("ItemController.detail Data IN => id: {}, amount: {}", id, amount);
    ItemResponseResource response =
        itemMapper.mapDomainToResource(itemService.findById(id, amount));
    log.info("ItemController.detail Data OUT => response: {}", response);
    return response;
  }
}
