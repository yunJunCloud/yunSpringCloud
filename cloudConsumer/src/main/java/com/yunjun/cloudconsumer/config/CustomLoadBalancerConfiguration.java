package com.yunjun.cloudconsumer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @ClassName CustomLoadBalancerConfiguration
 * @Description CustomLoadBalancerConfiguration is to handle xxxx 自定义负载均衡算法
 * @Author jack
 * @Date 9/1/2022 5:30 PM
 * @Version 1.0
 **/
public class CustomLoadBalancerConfiguration {
	@Bean
	ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
	                                                        LoadBalancerClientFactory loadBalancerClientFactory) {
		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//		return new RandomLoadBalancer(loadBalancerClientFactory
//				.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
		return new CustomLoadBalancerRule(loadBalancerClientFactory.getLazyProvider(name,ServiceInstanceListSupplier.class));
	}
}
