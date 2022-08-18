package com.yunjun.cloudconsulpayment.controller;

import com.yunjun.cloudconsulpayment.service.PaymentService;
import com.yunjun.cloudinterface.bean.CommonResult;
import com.yunjun.cloudinterface.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RequestMapping("/consul/payment")
public class PaymentController {

	@Value("${server.port}")
	private String port;

	private final PaymentService paymentService;

	private final  DiscoveryClient discoveryClient;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

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

	/**
	 * @author xiaofu
	 * @description 启动流程
	 * @date 2020/8/26 17:36
	 */
	@RequestMapping(value = "startLeaveProcess")
	@ResponseBody
	public String startLeaveProcess(String staffId) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("leaveTask", staffId);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Leave", map);
		StringBuilder sb = new StringBuilder();
		sb.append("创建请假流程 processId：" + processInstance.getId());
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(staffId).orderByTaskCreateTime().desc().list();
		for (Task task : tasks) {
			sb.append("任务taskId:" + task.getId());
		}
		return sb.toString();
	}


}
