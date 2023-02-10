package com.yunjun.cloudclient.controller;

import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import com.yunjun.cloudclient.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
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

	/**
	 * 测试fegin 超时
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getTimeOut/{id}")
	public CommonResult getPaymentTimeOut(@PathVariable("id") Long id) throws InterruptedException {
		TimeUnit.SECONDS.sleep(10);
		Payment payment = paymentService.selectById(id);
		log.info("******插入结果：" + payment);
		if (payment != null) {
			return new CommonResult(200, port+"查询成功", payment);
		} else {
			return new CommonResult(444, port+"没有查询记录", null);
		}
	}

	@GetMapping("/hystrix/testOk/{id}")
	public CommonResult paymentServiceOk(@PathVariable("id") Integer id){
		return new CommonResult(200,paymentService.paymentServiceOk(id));
	}

	@GetMapping("/hystrix/testTimeOut/{id}")
	public CommonResult paymentServiceTimeOut(@PathVariable("id") Integer id){
		return new CommonResult(200, paymentService.paymentServiceTimeOut(id));
	}

}
