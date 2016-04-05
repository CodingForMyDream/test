package com.qun.reflect;

public class ReflectDemo1 {

	public static void main(String[] args) {

		Foo foo = new Foo();

		/**
		 * ���������ʵ�ַ�ʽ
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
		 * c1,c2,c3���Ǵ���Foo��������ͣ�һ����ֻ������Class���һ��ʵ������
		 */
		System.out.println(c1 == c2); // true
		System.out.println(c2 == c3); // true

		/**
		 * newInstance();
		 * 1����ȡ����µ�ʵ������
		 * 2��Ĭ�ϵ�������޲ι��췽����������ʱ�׳��쳣
		 * 3��Foo��û�й��췽��ʱ��Ĭ�ϴ����޲ι��췽�������ڹ��췽��ʱ����Ҫ����޲ι��췽��
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