package com.abeldevelop.course.ajgspringcloud.item.api.controller.item;

import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ItemResource;
import com.abeldevelop.course.ajgspringcloud.item.api.controller.item.resource.ProductResource;
import com.abeldevelop.course.ajgspringcloud.item.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RequiredArgsConstructor
@RestController
public class ItemController {

  private final ItemService itemService;

  @Value("${configuracion.texto}")
  private String configuracionTexto;

  @GetMapping
  public List<ItemResource> findAll() {
    System.out.println(configuracionTexto);

    log.info("ItemController.findAll Data IN => empty");
    List<ItemResource> response = itemService.findAll();
    log.info("ItemController.findAll Data OUT => size: {}", response.size());
    return response;
  }

  @GetMapping("/{id}/amount/{amount}")
  public ItemResource detail(@PathVariable Long id, @PathVariable Integer amount) {
    log.info("ItemController.detail Data IN => id: {}, amount: {}", id, amount);
    ItemResource response = itemService.findById(id, amount);
    log.info("ItemController.detail Data OUT => response: {}", response);
    return response;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResource create(@RequestBody ProductResource request) {
    log.info("ItemController.create Data IN => ProductResource: {}", request);
    ProductResource response = itemService.create(request);
    log.info("ItemController.create Data OUT => ProductResource: {}", response);
    return response;
  }

  @PutMapping("/{id}")
  public ProductResource update(@PathVariable("id") Long id, @RequestBody ProductResource request) {
    log.info("ItemController.update Data IN => id: {}, ProductResource: {}", id, request);
    ProductResource response = itemService.update(id, request);
    log.info("ItemController.update Data OUT => ProductResource: {}", response);
    return response;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable("id") Long id) {
    log.info("ItemController.deleteById Data IN => id: {}", id);
    itemService.delete(id);
    log.info("ItemController.deleteById Data OUT => empty");
  }
}
