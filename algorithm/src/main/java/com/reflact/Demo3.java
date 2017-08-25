package 反射;

/**
 * Demo3: 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]
 */
public class Demo3 {
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> class1 = null;
	    class1 = Class.forName("反射.Person");
	    //由于这里不能带参数，所以你要实例化的这个类Person，一定要有无参构造函数
	    Person person = (Person) class1.newInstance();
	    person.setAge(27);
	    person.setName("yyc");
	    System.out.println("Test3: " + person.getName() + " : " + person.getAge());
	}
}
