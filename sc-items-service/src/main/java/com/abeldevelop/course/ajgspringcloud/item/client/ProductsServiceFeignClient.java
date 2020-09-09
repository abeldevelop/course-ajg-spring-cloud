package com.abeldevelop.course.ajgspringcloud.item.client;

import com.abeldevelop.course.ajgspringcloud.item.client.productsservice.product.ClientProductResponseResource;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("sc-products-service")
public interface ProductsServiceFeignClient {

  @GetMapping
  public List<ClientProductResponseResource> findAll();

  @GetMapping("/{id}")
  public ClientProductResponseResource findById(@PathVariable("id") Long id);
}
