package com.yunjun.cloudconsumer.controller;

import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderController
 * @Description OrderController is to handle xxxx
 * @Author jack
 * @Date 8/16/2022 3:55 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {
	public final String PAYMENT_URL = "http://consulClient";

	public final RestTemplate restTemplate;

	public OrderController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL+"/consul/payment/create",payment,CommonResult.class);
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
		return restTemplate.getForObject(PAYMENT_URL+"/consul/payment/get/"+id,CommonResult.class);
	}
}
