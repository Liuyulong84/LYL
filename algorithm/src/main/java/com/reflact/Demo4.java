package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Demo4: 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
 */
public class Demo4 {
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> class1 = null;
	    Person person1 = null;
	    Person person2 = null;
	 
	    class1 = Class.forName("反射.Person");
	    //得到一系列构造函数集合
	    Constructor<?>[] constructors = class1.getConstructors();
	 
	    try {
	        person1 = (Person) constructors[0].newInstance();
	    } catch (InvocationTargetException e) {
	        e.printStackTrace();
	    }
	    person1.setAge(28);
	    person1.setName("yyc");
	 
	    person2 = (Person) constructors[1].newInstance(29, "yyc");
	 
	    System.out.println("Test4: " + person1.getName() + " : " + person1.getAge() + "  ,   " + person2.getName() + " : " + person2.getAge());
	 
	
	}
}
