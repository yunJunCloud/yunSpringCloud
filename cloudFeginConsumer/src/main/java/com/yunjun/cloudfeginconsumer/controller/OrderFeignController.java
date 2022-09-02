package com.yunjun.cloudfeginconsumer.controller;

import com.yunjun.cloudfeginconsumer.service.ConsumerFeignService;
import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderFeginController
 * @Description OrderFeginController is to handle xxxx
 * @Author jack
 * @Date 9/2/2022 3:18 PM
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

	private final ConsumerFeignService consumerFeignService;

	public OrderFeignController(ConsumerFeignService consumerFeignService) {
		this.consumerFeignService = consumerFeignService;
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
		return consumerFeignService.getPayment(id);
	}

	@GetMapping("/payment/getTimeOut/{id}")
	public CommonResult<Payment> paymentFeginTimeout(@PathVariable("id") Long id){
		//openfegin-ribbon: 一般默认等待一秒,超过一秒报错
		return consumerFeignService.getTimeOut(id);
	}

}
