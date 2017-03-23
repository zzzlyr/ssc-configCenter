package com.itmuch.cloud.study.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @Author: zzz
 * @CreateTime: 2017/3/17 15:50
 * @Description:
 */
public class AvailabilityFilteringConfig {
    /**
     * 过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，
     并过滤掉那些高并发的的后端server（active connections 超过配置的阈值）
     使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个server的运行状态
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new AvailabilityFilteringRule();
    }

}
