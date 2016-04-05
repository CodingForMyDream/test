package com.qun.reflect;

public class ReflectDemo1 {

	public static void main(String[] args) {

		Foo foo = new Foo();

		/**
		 * 反射的三种实现方式
		 */
		Class c1 = Foo.class;
		Foo foo1 = null;
		Foo foo1_1 = null;
		try {
			foo1 = (Foo) c1.newInstance();
			foo1_1 = (Foo) c1.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		Class c2 = foo.getClass();
		Foo foo2 = null;
		try {
			foo2 = (Foo) c1.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		Class c3 = null;
		try {
			c3 = Class.forName("com.qun.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/**
		 * c1,c2,c3都是代表Foo类的类类型，一个类只可能是Class类的一个实例对象
		 */
		System.out.println(c1 == c2); // true
		System.out.println(c2 == c3); // true

		/**
		 * newInstance();
		 * 1，获取类的新的实例对象；
		 * 2，默认调用类的无参构造方法，不存在时抛出异常
		 * 3，Foo中没有构造方法时，默认存在无参构造方法；存在构造方法时，需要添加无参构造方法
		 */
		System.out.println(foo1_1 == foo1); // false
		System.out.println(foo == foo1); // false
		System.out.println(foo1 == foo2); // false
	}

}

class Foo {

	private String name;
	
	public Foo() {
		
	}
	
	public Foo(String name) {
		this.name = name;
	}
}