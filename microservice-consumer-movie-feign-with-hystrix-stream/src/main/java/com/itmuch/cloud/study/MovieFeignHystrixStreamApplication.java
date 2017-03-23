package com.itmuch.cloud.study;

import com.itmuch.cloud.study.config.RandomConfig;
import com.itmuch.cloud.study.config.RetryRuleConfig;
import com.itmuch.cloud.study.filter.ExcludeFromComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 使用@EnableFeignClients开启Feign
 * @author eacdy
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
//配置不扫描这个配置文件类
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
@RibbonClient(name = "microservice-provider-user", configuration = RetryRuleConfig.class) //单独指定ribbon的负载策略
public class MovieFeignHystrixStreamApplication {
  public static void main(String[] args) {
    SpringApplication.run(MovieFeignHystrixStreamApplication.class, args);
  }
}
