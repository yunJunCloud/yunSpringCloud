package com.yunjun.ribbon;

/**
 * @ClassName Car
 * @Description Car is to handle xxxx
 * @Author jack
 * @Date 8/26/2022 1:39 PM
 * @Version 1.0
 **/
public class Car {

	public static void main(String[] args) {

		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
		System.out.println(car3.hashCode());

		Class<? extends Car> aClass = car1.getClass();
		Class<? extends Car> bClass = car1.getClass();
		System.out.println(aClass);
		System.out.println(bClass);

		ClassLoader classLoader = aClass.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		/**
		 * 1、类加载器收到类加载的请求
		 * 2、将这个请求向上委托给父类加载器去完成，一直向上委托  app - EXC(拓展类加载器) - root（根加载器）
		 * 3、启动加载器检查是否能够加载当前这个类，能加载就结束，使用当前的加载器，否则，抛出异常，通知子加载器进行加载
		 */
	}
}
