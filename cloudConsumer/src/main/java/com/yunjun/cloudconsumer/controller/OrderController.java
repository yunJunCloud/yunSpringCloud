package com.yunjun.cloudconsumer.controller;

import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
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
	public final String PAYMENT_URL = "http://clientOne";

	@Autowired
//	public RestTemplate restTemplate;
	private RestOperations restTemplate;

	public OrderController() {
	}

	@GetMapping("/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
		return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
	}

	@GetMapping("/payment/get2/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		if(entity.getStatusCode().is2xxSuccessful()){
			log.info(entity.getStatusCode()+"\t"+entity.getHeaders());
			return entity.getBody();
		}else {
			return new CommonResult<>(444,"获取失败!!!");
		}

	}
}
