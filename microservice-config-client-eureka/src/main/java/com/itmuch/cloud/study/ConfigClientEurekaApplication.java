package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientEurekaApplication {
  public static void main(String[] args) {
    //SpringApplication.run(ConfigClientEurekaApplication.class, args);
    new SpringApplicationBuilder(ConfigClientEurekaApplication.class).web(true).run(args);
  }
}
