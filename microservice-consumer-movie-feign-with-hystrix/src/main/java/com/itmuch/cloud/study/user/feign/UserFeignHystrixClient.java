package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignHystrixClient.HystrixClientFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * @author eacdy ,configuration=FooConfiguration.class
 */
@FeignClient(name = "MICROSERVICE-PROVIDER-USER", fallback = HystrixClientFallback.class)
public interface UserFeignHystrixClient {
  @RequestMapping("/{id}")
  public User findByIdFeign(@RequestParam("id") Long id);

  @RequestMapping("/user/{id}")
  //hystrix 进行每一个服务进行线程隔离限流配置
  @HystrixCommand(commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")},
          threadPoolProperties = {
                  @HystrixProperty(name = "coreSize", value = "30"),
                  @HystrixProperty(name = "maxQueueSize", value = "101"),
                  @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                  @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                  @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                  @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
          })
  public String userById(@RequestParam("id") Long id);

  /**
   * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
   * @author eacdy
   */
  @Component
  static class HystrixClientFallback implements UserFeignHystrixClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    @Override
    public User findByIdFeign(Long id) {
      HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
      User user = new User();
      user.setId(-1L);
      user.setUsername("default username");
      user.setAge(0);
      return user;
    }

    @Override
    public String userById(@RequestParam("id") Long id) {
      HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
      return "这是返回json容断信息!";
    }
  }
}
