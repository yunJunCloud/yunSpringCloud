package com.yunjun.cloudredis.service;

/**
 * @ClassName IRedisCluster
 * @Description IRedisCluster is to handle xxxx
 * @Author jack
 * @Date 8/11/2022 5:40 PM
 * @Version 1.0
 **/
public interface IRedisCluster {
	String set(String key, String value);

	String get(String key);
}
