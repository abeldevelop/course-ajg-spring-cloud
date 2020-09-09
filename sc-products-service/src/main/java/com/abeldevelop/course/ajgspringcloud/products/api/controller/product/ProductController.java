package com.abeldevelop.course.ajgspringcloud.products.api.controller.product;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResponseResource;
import com.abeldevelop.course.ajgspringcloud.products.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

  @Value("${server.port}")
  private Integer port;

  private final ProductService productService;

  @GetMapping
  public List<ProductResponseResource> findAll() {
    System.out.println(port);
    log.info("ProductController.findAll Data IN => empty");
    List<ProductResponseResource> response = productService.findAll();
    log.info("ProductController.findAll Data OUT => size: {}", response.size());
    return response;
  }

  @GetMapping("/{id}")
  public ProductResponseResource findById(@PathVariable("id") Long id) {
    log.info("ProductController.findById Data IN => id: {}", id);
    ProductResponseResource response = productService.findById(id);
    log.info("ProductController.findById Data OUT => response: {}", response);
    return response;
  }
}
