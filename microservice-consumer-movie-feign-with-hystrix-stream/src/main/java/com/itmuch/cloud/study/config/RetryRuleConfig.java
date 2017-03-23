package com.itmuch.cloud.study.config;

import com.itmuch.cloud.study.filter.ExcludeFromComponentScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zzz
 * @CreateTime: 2017/3/17 15:20
 * @Description:
 */
@Configuration
@ExcludeFromComponentScan //自定义注解，不扫描此配置类
public class RetryRuleConfig {
    /**
     * 一、Ribbon中的负载均衡策略

     1、Ribbon中支持的负载均衡策略

     AvailabilityFilteringRule：过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，
     并过滤掉那些高并发的的后端server（active connections 超过配置的阈值）
     使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个server的运行状态

     RandomRule：随机选择一个server

     BestAvailabl：选择一个最小的并发请求的server，逐个考察Server，如果Server被tripped了，则忽略

     RoundRobinRule：roundRobin方式轮询选择， 轮询index，选择index对应位置的server

     WeightedResponseTimeRule：根据响应时间分配一个weight(权重)，响应时间越长，weight越小，被选中的可能性越低

     RetryRule：对选定的负载均衡策略机上重试机制，在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server

     ZoneAvoidanceRule：复合判断server所在区域的性能和server的可用性选择server

     ResponseTimeWeightedRule：作用同WeightedResponseTimeRule，二者作用是一样的，ResponseTimeWeightedRule后来改名为WeightedResponseTimeRule
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RetryRule( new RandomRule(),6);
    }

}
