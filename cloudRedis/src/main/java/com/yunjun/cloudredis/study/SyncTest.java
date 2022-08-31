package com.yunjun.cloudredis.study;

/**
 * @ClassName SyncTest
 * @Description SyncTest is to handle xxxx
 * @Author jack
 * @Date 8/22/2022 11:08 AM
 * @Version 1.0
 **/
public class SyncTest {
	public static void main(String[] args) {
		synchronized (SyncTest.class){
			System.out.println("同步代码快中，锁为synchronized括号中配置的对象");
		}
	}

	public synchronized  void  fun(){
		System.out.println("普通同步方法中，锁是当前实例对象this");
	}

	public synchronized  static void fun1(){
		System.out.println("静态同步方法，锁是当前类的class对象");
	}

}
