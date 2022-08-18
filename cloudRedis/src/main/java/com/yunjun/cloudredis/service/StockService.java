package com.yunjun.cloudredis.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName StockService
 * @Description StockService is to handle xxxx
 * @Author jack
 * @Date 8/11/2022 7:44 PM
 * @Version 1.0
 **/
@Service
public class StockService {

	private final RedissonClient redissonClient;

	private final String key_pre = "redisKey_";

	public StockService(RedissonClient redissonClient) {
		this.redissonClient = redissonClient;
	}

	public String decrStock(String key){
		RLock lock = redissonClient.getLock(key_pre + key);  //获取锁对象
		boolean isLock;
		try {
			isLock = lock.tryLock(); //使用默认方式获取：默认在时间30s  是LOCKEXPIRATIONINTERVAL_SECONDS
			// 因为上一行获取到了，这里获取不到：如果获取到了就500ms, 就认为获取锁失败。10000ms即10s是锁失效时间。
			isLock = lock.tryLock(500, 10000, TimeUnit.MILLISECONDS);
			if(isLock){
				//如果获取到锁，就进行操作

			}
		}catch (Exception e){

		}
		return "";
	}
}
