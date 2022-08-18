package com.yunjun.cloudconsulpayment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunjun.cloudinterface.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName PaymentMapper
 * @Description PaymentMapper is to handle xxxx
 * @Author jack
 * @Date 8/12/2022 5:39 PM
 * @Version 1.0
 **/
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
