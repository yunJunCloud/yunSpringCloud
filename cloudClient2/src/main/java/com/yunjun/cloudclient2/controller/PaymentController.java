package com.yunjun.cloudclient2.controller;

import com.yunjun.cloudclient2.service.PaymentService;
import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PaymentController
 * @Description PaymentController is to handle xxxx
 * @Author jack
 * @Date 8/12/2022 5:52 PM
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

	@Value("${server.port}")
	private String port;

	private final PaymentService paymentService;

	private final  DiscoveryClient discoveryClient;

	public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
		this.paymentService = paymentService;
		this.discoveryClient = discoveryClient;
	}

	//返回给前端的结果集
	@PostMapping(value = "/create")
	public CommonResult create(@RequestBody Payment payment) {
		Integer result = paymentService.insert(payment);
		log.info("******插入结果：" + result);
		if (result > 0) {
			return new CommonResult(200, "插入数据库成功",result);
		} else {
			return new CommonResult(444, "插入数据库失败", null);
		}
	}
	@GetMapping(value = "/get/{id}")
	public CommonResult getPaymentByID(@PathVariable("id") Long id) {
		Payment payment = paymentService.selectById(id);
		log.info("******插入结果：" + payment);
		if (payment != null) {
			return new CommonResult(200, port+"查询成功", payment);
		} else {
			return new CommonResult(444, port+"没有查询记录", null);
		}
	}

	@GetMapping(value = "/discovery")
	public Object discovery(){
		//获得服务清单列表
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			log.info("*****element:"+service);
		}

		// 根据具体服务进一步获得该微服务的信息
		List<ServiceInstance> instances = discoveryClient.getInstances("client1");
		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
		}
		return this.discoveryClient;
	}


}
