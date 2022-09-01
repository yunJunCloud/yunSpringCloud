//package com.yunjun.ribbon;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.*;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.List;
//
///**
// * @ClassName MySelRule
// * @Description MySelRule is to handle xxxx 自定义负载均衡策略
// * @Author jack
// * @Date 8/21/2022 4:12 PM
// * @Version 1.0
// **/
//@Slf4j
//public class MySelRule extends AbstractLoadBalancerRule {
//	private int total = 0;
//	private int currentIndex = 0;
//
//	@Override
//	public void initWithNiwsConfig(IClientConfig iClientConfig) {
//
//	}
//
//	public Server choose(ILoadBalancer lb, Object key) {
//		if(lb == null){
//			return null;
//		}
//		Server server = null;
//		while (null == server){
//			/***
//			 * 1、thread.interrupt(); 中断此线程 谁调用的就中断谁，相当于给该线程设置一个中断的标志，线程任会继续执行
//			 * 2、Thread.interrupted(); 测试当前线程是否已被中断，也就是检查当前线程是和存在中断标志，测试完成之后会清除这个中断标志
//			 * 3、thread.isInterrupted(); 获取线程的中断情况，不会清除中断标志
//			 */
//			if(Thread.interrupted()){
////				Thread thread = new Thread();
////				thread.start();
////				thread.isInterrupted();
////				thread.join();
//				return null;
//			}
//			//所有注册的服务列表
//			List<Server> allServers = lb.getAllServers();
//			//获取所有有效的服务示例表
//			List<Server> upList = lb.getReachableServers();
//
//			int upCount = upList.size();
//			int serverCount = allServers.size();
//
//			if ((upCount == 0) || (serverCount == 0)) {
//				log.warn("No up servers available from load balancer: " + lb);
//				return null;
//			}
//			//与随机策略相似，但每个服务实例只有在调用 3 次之后，才会调用其他的服务实例
//			if(total < 3){
//				server = upList.get(currentIndex);
//				total ++;
//			}else {
//				total = 0;
//				currentIndex++;
//				if(currentIndex >= upCount){
//					currentIndex = 0;
//				}
//			}
//
//			if(null == server){
//				//让出当前cpu资源   当前线程可能再次获得到
//				Thread.yield();
//				continue;
//			}
//
//			if (server.isAlive() && (server.isReadyToServe())) {
//				return (server);
//			}
//
//			server = null;
//			Thread.yield();
//
//		}
//		return server;
//	}
//
//	@Override
//	public Server choose(Object key) {
//		return choose(getLoadBalancer(),key);
//	}
//}
