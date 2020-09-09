package com.abeldevelop.course.ajgspringcloud.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScProductsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScProductsServiceApplication.class, args);
  }
}
