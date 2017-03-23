package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * http://localhost:8761/eureka/apps 可以查看xml形式的信息
 http://localhost:8761/eureka/apps/{serviceId} 例：http://localhost:8761/eureka/apps/MICROSERVICE-CONSUMER-MOVIE-RIBBON-WITH-HYSTRIX 可以查看单个的
 * 使用Eureka做服务发现.
 * @author eacdy
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
    //启用web服务的变量
    //new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
  }
}
