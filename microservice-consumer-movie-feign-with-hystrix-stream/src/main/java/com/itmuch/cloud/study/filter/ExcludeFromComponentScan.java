package com.itmuch.cloud.study.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zzz
 * @CreateTime: 2017/3/17 15:25
 * @Description: 定义一个注释，在spring boot( @ComponentScan ) 扫描的时候排除这个配置文件
 *
 *  @ComponentScan 这个注释中其中有一个 @interface Filter 表示可以排除，然后在启去类中配置下
 *  详情请见启动类 排除：
 *  @ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
 *
 *  包含：
 *  @ComponentScan(includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcludeFromComponentScan {

}
