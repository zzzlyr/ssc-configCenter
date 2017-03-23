package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignHystrixClient;

import java.util.List;

@RestController
public class FeignHystrixController {
  @Autowired
  private DiscoveryClient discoveryClient;

  @Autowired
  private UserFeignHystrixClient userFeignHystrixClient;

  @GetMapping("feign/{id}")
  public User findByIdFeign(@PathVariable Long id) {
    User user = this.userFeignHystrixClient.findByIdFeign(id);
    return user;
  }

  /**
   * 测试ribbo客户端负载策略器
   * @param id
   * @return
     */
  @GetMapping("user/{id}")
  public String userById(@PathVariable Long id) {
    return this.userFeignHystrixClient.userById(id);
  }
  /**
   * 本地服务实例的信息,通过eureka获取注册的服务
   * @return
   */
  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    List<String> listServer=discoveryClient.getServices();
    for(String s : listServer){
      System.out.println("server="+s);
    }
    return localServiceInstance;
  }
}
