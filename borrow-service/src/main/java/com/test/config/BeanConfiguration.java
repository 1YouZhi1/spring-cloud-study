package com.test.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author YouZhi
 * 指定为 userservice 服务，只要是调用此服务都会使用我们指定的策略
 * 指定我们刚刚定义好的配置类
 */
@Configuration
@LoadBalancerClient(value = "userservice", configuration = LoadBalancerConfig.class)
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    RestTemplate template(){
        return new RestTemplate();
    }
}
