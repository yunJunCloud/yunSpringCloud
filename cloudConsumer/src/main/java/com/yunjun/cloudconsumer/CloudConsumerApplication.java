package com.yunjun.cloudconsumer;

import com.yunjun.cloudconsumer.config.CustomLoadBalancerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
//@RibbonClient(value = "client1",configuration = MySelRuleConfig.class)
@LoadBalancerClient(value = "clientOne",configuration = CustomLoadBalancerConfiguration.class)
public class CloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerApplication.class, args);
	}

}
