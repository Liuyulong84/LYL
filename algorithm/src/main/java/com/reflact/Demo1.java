package 反射;

/**
 * Demo1: 通过Java反射机制得到类的包名和类名
 */
public class Demo1 {
	public static void main(String args[]) {
	    Person person = new Person();
	    System.out.println("Test1: 包名: " + person.getClass().getPackage().getName() + "，" + "完整类名: " + person.getClass().getName());
	}
}
