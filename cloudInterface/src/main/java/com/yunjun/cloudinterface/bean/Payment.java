package com.yunjun.cloudinterface.bean;

import com.yunjun.cloudinterface.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Payment
 * @Description Payment is to handle xxxx
 * @Author jack
 * @Date 8/16/2022 3:28 PM
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseModel {
	private Long id;
	private String serial;
}
