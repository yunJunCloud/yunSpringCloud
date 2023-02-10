package com.yunjun.cloudclient.service.impl;

import com.yunjun.cloudclient.base.BaseServiceImpl;
import com.yunjun.cloudinterface.bean.Payment;
import com.yunjun.cloudclient.mapper.PaymentMapper;
import com.yunjun.cloudclient.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentServiceImpl
 * @Description PaymentServiceImpl is to handle xxxx
 * @Author jack
 * @Date 8/12/2022 5:48 PM
 * @Version 1.0
 **/
@Service
@Slf4j
public class PaymentServiceImpl extends BaseServiceImpl<PaymentMapper, Payment> implements PaymentService {
	private final PaymentMapper paymentMapper;

	public PaymentServiceImpl(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}

	@Override
	public String paymentServiceOk(Integer _id){
		return String.format("线程池： %s, paymentServiceOk这是个正常的请求！！！+ 请求的id是 %s",Thread.currentThread().getName(),_id);
	}

	@Override
	public String paymentServiceTimeOut(Integer _id)  {
		int timeNumber = 5;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		return String.format("线程池： %s, paymentServiceTimeOut这是个超时测试的请求！！！+ 请求的id是 %s",Thread.currentThread().getName(),_id);
	}

//	public static void main(String[] args) {
//		String str = String.format("线程池： %s, 这是个正常的请求！！！+ 请求的id是 %s", Thread.currentThread().getName(), 12);
//		System.out.println(str);
//	}
}
