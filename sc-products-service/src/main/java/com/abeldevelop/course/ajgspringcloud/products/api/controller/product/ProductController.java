package com.abeldevelop.course.ajgspringcloud.products.api.controller.product;

import com.abeldevelop.course.ajgspringcloud.products.api.controller.product.resource.ProductResource;
import com.abeldevelop.course.ajgspringcloud.products.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor
@RestController
public class ProductController {

  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResource create(@RequestBody ProductResource request) {
    log.info("ProductController.create Data IN => ProductResource: {}", request);
    ProductResource response = productService.create(request);
    log.info("ProductController.create Data OUT => ProductResource: {}", response);
    return response;
  }

  @PutMapping("/{id}")
  public ProductResource update(@PathVariable("id") Long id, @RequestBody ProductResource request) {
    log.info("ProductController.update Data IN => id: {}, ProductResource: {}", id, request);
    ProductResource response = productService.update(id, request);
    log.info("ProductController.update Data OUT => ProductResource: {}", response);
    return response;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable("id") Long id) {
    log.info("ProductController.deleteById Data IN => id: {}", id);
    productService.deleteById(id);
    log.info("ProductController.deleteById Data OUT => empty");
  }

  @GetMapping("/{id}")
  public ProductResource findById(@PathVariable("id") Long id) {
    log.info("ProductController.findById Data IN => id: {}", id);
    ProductResource response = productService.findById(id);
    log.info("ProductController.findById Data OUT => response: {}", response);
    return response;
  }

  @GetMapping
  public List<ProductResource> findAll() {
    log.info("ProductController.findAll Data IN => empty");
    List<ProductResource> response = productService.findAll();
    log.info("ProductController.findAll Data OUT => size: {}", response.size());
    return response;
  }
}
