package com.abeldevelop.course.ajgspringcloud.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ScItemServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScItemServiceApplication.class, args);
  }
}
