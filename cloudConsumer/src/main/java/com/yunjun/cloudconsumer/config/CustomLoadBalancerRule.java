package com.yunjun.cloudconsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @ClassName CustomLoadBalancer
 * @Description CustomLoadBalancer is to handle xxxx
 * @Author jack
 * @Date 9/1/2022 8:05 PM
 * @Version 1.0
 **/
@Slf4j
public class CustomLoadBalancerRule implements ReactorServiceInstanceLoadBalancer {

	private int total=0;    // 被调用的次数
	private int index=0;    // 当前是谁在提供服务

	private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

	public CustomLoadBalancerRule(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
		this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
	}

	@Override
	public Mono<Response<ServiceInstance>> choose(Request request) {
		ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider.getIfAvailable();
		return supplier.get().next().map(this::getInstanceResponse);
	}

	@Override
	public Mono<Response<ServiceInstance>> choose() {
		return ReactorServiceInstanceLoadBalancer.super.choose();
	}

	//每个服务访问5次，然后换下一个服务
	private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances) {
		log.info("进入自定义负载均衡");
		if (instances.isEmpty()) {
			return new EmptyResponse();
		}

		log.info("每个服务访问5次后轮询");
		int size = instances.size();

		ServiceInstance serviceInstance=null;
		while (serviceInstance == null) {
			if (total < 5) {
				serviceInstance = instances.get(index);
				total++;
			} else {
				total=0;
				index++;
				if (index>=size) {
					index=0;
				}
				serviceInstance=instances.get(index);
			}
		}

		return new DefaultResponse(serviceInstance);

	}
}
