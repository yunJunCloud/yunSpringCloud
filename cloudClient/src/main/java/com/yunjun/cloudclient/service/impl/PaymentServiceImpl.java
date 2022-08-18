package com.yunjun.cloudclient.service.impl;

import com.yunjun.cloudclient.base.BaseServiceImpl;
import com.yunjun.cloudinterface.bean.Payment;
import com.yunjun.cloudclient.mapper.PaymentMapper;
import com.yunjun.cloudclient.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
