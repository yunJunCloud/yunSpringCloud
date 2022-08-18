package com.yunjun.cloudclient2.service.impl;

import com.yunjun.cloudclient2.base.BaseServiceImpl;
import com.yunjun.cloudclient2.mapper.PaymentMapper;
import com.yunjun.cloudclient2.service.PaymentService;
import com.yunjun.cloudinterface.bean.Payment;
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
