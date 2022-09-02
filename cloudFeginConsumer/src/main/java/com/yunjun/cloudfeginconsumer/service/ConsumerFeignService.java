package com.yunjun.cloudfeginconsumer.service;

import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName CunsumerFeignService
 * @Description CunsumerFeignService is to handle xxxx
 * @Author jack
 * @Date 9/2/2022 3:14 PM
 * @Version 1.0
 **/
@Component
@FeignClient(value = "clientOne")
public interface ConsumerFeignService {

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

	@GetMapping(value = "/payment/getTimeOut/{id}")
	public CommonResult<Payment> getTimeOut(@PathVariable("id") Long id);
}
