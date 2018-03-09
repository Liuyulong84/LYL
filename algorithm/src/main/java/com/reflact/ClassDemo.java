package com.reflact;

public class ClassDemo {
	public class Person{
		public Person(){
			
		}
	}
	
	public void test(){
		//方式一
	    Person person = new Person();
	    Class<? extends Person> personClazz01 = person.getClass();
	 
	    //方式二
	    try {
	        Class<?> personClazz02 = Class.forName("Person");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	    //方式三
	    Class<? extends Person> personClazz03 = Person.class;
	}
}
