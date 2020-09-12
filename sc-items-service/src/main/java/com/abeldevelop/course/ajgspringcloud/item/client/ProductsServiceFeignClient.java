package com.abeldevelop.course.ajgspringcloud.item.client;

import com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product.ClientProductResponseResource;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("sc-products-service")
public interface ProductsServiceFeignClient {

  @GetMapping
  List<ClientProductResponseResource> findAll();

  @GetMapping("/{id}")
  ClientProductResponseResource findById(@PathVariable("id") Long id);

  @PostMapping
  ClientProductResponseResource create(@RequestBody ClientProductResponseResource request);

  @PutMapping("/{id}")
  ClientProductResponseResource update(
      @PathVariable("id") Long id, @RequestBody ClientProductResponseResource request);

  @DeleteMapping("/{id}")
  void deleteById(@PathVariable("id") Long id);
}
