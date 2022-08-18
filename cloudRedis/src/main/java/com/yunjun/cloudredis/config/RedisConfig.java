package com.yunjun.cloudredis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @ClassName RedisConfig
 * @Description RedisConfig is to handle xxxx
 * @Author jack
 * @Date 8/11/2022 5:23 PM
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {
	@Value("${redisCluster.ports}")
	private String redisClusterPorts ;
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

		/* 设置value的序列化规则和 key的序列化规则 */
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

		redisTemplate.setKeySerializer(stringRedisSerializer);                // key采用String的序列化方式
		redisTemplate.setHashKeySerializer(stringRedisSerializer);            // hash的key也采用String的序列化方式
		redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer); // value序列化方式采用jackson
		redisTemplate.setConnectionFactory(connectionFactory);                // 默认使用letttuce，如果想使用Jedis，创建JedisConnectionFactory实例作为参数传入

		return redisTemplate;
	}

	@Bean
	public RedissonClient getRedisson(){
		Config config = new Config();
		config.useSentinelServers().addSentinelAddress(redisClusterPorts).setDatabase(0);
		RedissonClient redissonClient = Redisson.create(config);
		return redissonClient;
	}
}
