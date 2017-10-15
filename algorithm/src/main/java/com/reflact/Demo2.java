package com.reflact;

import com.reflact.Person;

/**
 * Demo2: 验证所有的类都是Class类的实例对象
 */
public class Demo2 {
	public static void main(String args[]) throws ClassNotFoundException {
		 //定义两个类型都未知的Class , 设置初值为null, 看看如何给它们赋值成Person类
	    Class<?> class1 = null;
	    Class<?> class2 = null;
	 
	    //写法1, 可能抛出 ClassNotFoundException [多用这个写法]
	    class1 = Class.forName("反射.Person");
	    System.out.println("Test2:(写法1) 包名: " + class1.getPackage().getName() + "，" + "完整类名: " + class1.getName());
	 
	    //写法2
	    class2 = Person.class;
	    System.out.println("Test2:(写法2) 包名: " + class2.getPackage().getName() + "，" + "完整类名: " + class2.getName());
	}
}
