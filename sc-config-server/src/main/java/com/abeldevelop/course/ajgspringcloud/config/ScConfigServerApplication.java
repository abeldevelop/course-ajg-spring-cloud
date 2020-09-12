package com.abeldevelop.course.ajgspringcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ScConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScConfigServerApplication.class, args);
  }
}
