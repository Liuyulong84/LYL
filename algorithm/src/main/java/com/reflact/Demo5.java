package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Demo5: 通过Java反射机制调用类方法
 */
public class Demo5 {
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		 Class<?> class1 = null;
		    class1 = Class.forName("反射.SuperPerson");
		 
		    System.out.println("Test7: \n调用无参方法fly()：");
		    Method method = class1.getMethod("fly");
		    method.invoke(class1.newInstance());
		 
		    System.out.println("调用有参方法smoke(int m)：");
		    method = class1.getMethod("smoke", int.class);
		    method.invoke(class1.newInstance(), 100);
	
	}
}
