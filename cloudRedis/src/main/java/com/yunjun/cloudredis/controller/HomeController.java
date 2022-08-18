package com.yunjun.cloudredis.controller;

import com.yunjun.cloudredis.service.IRedisCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HomeController
 * @Description HomeController is to handle xxxx
 * @Author jack
 * @Date 8/11/2022 5:07 PM
 * @Version 1.0
 **/
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	@Qualifier("redisClusterTemplateService")
	private IRedisCluster redisTemplateCluster;

	@PostMapping("/cluster/{key}")
	public void setData(@PathVariable("key") String key){
		System.out.println("set " + key);
		redisTemplateCluster.set(key,key + " nice");
	}

	@GetMapping("/cluster/{key}")
	public void getData(@PathVariable("key") String key){
		System.out.println(redisTemplateCluster.get(key));
	}

}
