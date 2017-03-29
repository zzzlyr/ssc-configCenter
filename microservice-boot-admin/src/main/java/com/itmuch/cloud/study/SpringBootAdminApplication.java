package com.itmuch.cloud.study;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zzz
 * @CreateTime: 2017/3/23 19:37
 * @Description: spring boot admin 是对spring boot 应用监控提供UI页面
 * 它在Spring Boot Actuator的基础上提供简洁的可视化WEB UI。
 * Spring Boot提供的监控接口，例如：/health、/info等等，实际上除了之前提到的信息，
 * 还有其他信息业需要监控：当前处于活跃状态的会话数量、当前应用的并发数、延迟以及其他度量信息。
 * 这次我们了解如何利用Spring-boot-admin对应用信息进行可视化，
 * 如何添加度量信息
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer //启用spring boot admin 管理
public class SpringBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }

}
