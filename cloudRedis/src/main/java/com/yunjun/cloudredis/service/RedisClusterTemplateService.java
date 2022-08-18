package com.yunjun.cloudredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName RedisClusterTemplateService
 * @Description RedisClusterTemplateService is to handle xxxx
 * @Author jack
 * @Date 8/11/2022 5:38 PM
 * @Version 1.0
 **/
@Service("redisClusterTemplateService")
public class RedisClusterTemplateService implements IRedisCluster{
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	@Override
	public String set(String key, String value) {
		redisTemplate.opsForValue().set(key,value);
		return key;
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
}
