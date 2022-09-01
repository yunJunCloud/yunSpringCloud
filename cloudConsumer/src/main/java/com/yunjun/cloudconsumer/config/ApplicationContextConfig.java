package com.yunjun.cloudconsumer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

/**
 * @ClassName ApplicationContextConfig
 * @Description ApplicationContextConfig is to handle xxxx
 * @Author jack
 * @Date 8/16/2022 3:52 PM
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig {

//	@Bean
//	@LoadBalanced  //负载均衡
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}

	@Bean
	@LoadBalanced  //负载均衡
	//建议用新版 RestOperations
	public RestOperations getRestTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

//	@Bean
//	public IRule myRule(){
//		return new RandomRule();
//	}
}
