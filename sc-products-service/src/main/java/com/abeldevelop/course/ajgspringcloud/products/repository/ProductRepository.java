package com.abeldevelop.course.ajgspringcloud.products.repository;

import com.abeldevelop.course.ajgspringcloud.products.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {}
