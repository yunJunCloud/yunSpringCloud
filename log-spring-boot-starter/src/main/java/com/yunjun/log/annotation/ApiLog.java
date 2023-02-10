package com.yunjun.log.annotation;

import com.yunjun.log.bean.OperateEnum;

import java.lang.annotation.*;

/**
 * @ClassName ApiLog
 * @Description ApiLog is to handle xxxx
 * @Author jack
 * @Date 2/10/2023 4:56 PM
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {
	/**
	 * 操作类型
	 * @return
	 */
	OperateEnum operateType() default OperateEnum.OTHER;

	/**
	 * 所属模块
	 * @return
	 */
	String operateModule() default "其他模块";

	/**
	 * 是否需要记录
	 * @return
	 */
	boolean  recordResult() default  false;
}
