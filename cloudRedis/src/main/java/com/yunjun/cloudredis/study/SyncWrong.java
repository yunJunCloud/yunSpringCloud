package com.yunjun.cloudredis.study;

/**
 * @ClassName SyncWrong
 * @Description SyncWrong is to handle xxxx
 * @Author jack
 * @Date 8/22/2022 11:16 AM
 * @Version 1.0
 **/
public class SyncWrong implements Runnable{
	private static int i = 0;

	private synchronized void add(){
		//普通方法锁的是当前的对象的实例，对不同的实例是不起作用的
		//无法保证不同实例的线程安全
		i++;
	}

	private synchronized static void add1(){
		//静态方法锁的是当前类 SyncWrong.class,可以保证对这个类操作时，线程安全
		i++;
	}

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			add();
		}
	}

	/**
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	/**
	 * 1、测试不同实例调用普通方法的线程安全问题
	 * @throws InterruptedException
	 */
	public static void test1() throws InterruptedException {
		SyncWrong syncWrong = new SyncWrong();
		Thread thread1 = new Thread(syncWrong);
		Thread thread2 = new Thread(syncWrong);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(i);
	}

	/**
	 * 1、测试不同实例调用普通方法的线程安全问题
	 * @throws InterruptedException
	 */
	public static void test2() throws InterruptedException {
		Thread thread1 = new Thread(new SyncWrong());
		Thread thread2 = new Thread(new SyncWrong());
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(i);
	}


}
