package com.yonyou.ssc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 这是启动容器的入口类，类似启动tomcat
 * 第一种方式
 通过在UserController中加上@EnableAutoConfiguration开启自动配置，
 然后通过SpringApplication.run(UserController.class);运行这个控制器；这种方式只运行一个控制器比较方便；
 第二种方式
 通过@Configuration+@ComponentScan开启注解扫描并自动注册相应的注解Bean
 * 如果把 spring boot 入口类放到工作中根目录，@SpringBootApplication 等同下边三个注解
 * 默认去扫描入口类下边所有的子包。
 *
 * 入口类Application继承SpringBootServletInitializer并重写configure方法。
 * 运行主方法后，会将我们的web项目打包成war，并默认启动一个端口为8080的tomcat容器来运行我们的Web项目
 */
/*@Configuration
@ComponentScan(basePackages = "com.yonyou.ssc")//扫描这个包下的所有注解
@EnableAutoConfiguration //开启自动配置功能(debug才能使用)*/
@SpringBootApplication//这个相当于上边三个注解，官方建议直接放在包的根目录
//启注解事务管理
@EnableTransactionManagement
public class DemoSpringbootApplication extends SpringBootServletInitializer {

	/**
	 * 继承 SpringBootServletInitializer 重写 configure 用maven可以打包web形式的war包
	 * 可以直接部暑到类似tomcat容器中运行
	 * @param application
	 * @return
     */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoSpringbootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootApplication.class, args);
	}
}
