package com.yunjun.cloudfeginconsumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeginConfig
 * @Description FeginConfig is to handle xxxx
 * @Author jack
 * @Date 9/2/2022 3:41 PM
 * @Version 1.0
 **/
@Configuration
public class FeignConfig {
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}

}
