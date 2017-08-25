package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Demo6: 通过Java反射机制得到类加载器信息
 * <p/>
 * 在java中有三种类类加载器。
 * <p/>
 * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
 * <p/>
 * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
 * <p/>
 * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
 *
 * @throws ClassNotFoundException
 */
public class Demo6 {
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> class1 = null;
	    class1 = Class.forName("com.tuba.yuanyc.audiomanagerdemo.SuperPerson");
	    String name = class1.getClassLoader().getClass().getName();
	 
	    System.out.println("Test8: 类加载器类名: " + name);
	
	}
}
