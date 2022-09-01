//package com.yunjun.ribbon;
//
//import com.netflix.loadbalancer.IRule;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @ClassName MySelRuleConfig
// * @Description MySelRuleConfig is to handle xxxx
// * @Author jack
// * @Date 8/30/2022 2:29 PM
// * @Version 1.0
// **/
////@Configuration
////@LoadBalancerClient(value = "clientOne",configuration = MySelRule.class)
//public class MySelRuleConfig {
//
//	@Bean
//	public IRule myRule(){
//		//注册自定义负载均衡
//		return new MySelRule();
//	}
//}
