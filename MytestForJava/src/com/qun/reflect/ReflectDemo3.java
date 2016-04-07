package com.qun.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射执行对象的方法
 * @author 佳俊
 *
 */
public class ReflectDemo3 {

	public static void main(String[] args) {
		Test test = new Test();
		Class c = test.getClass();
		/**
		 * 理解：正常的调用test.print()，用test对象操作方法pringt对象
		 * 反射的过程是，获取方法对象print的对象，反过来操作实体对象test
		 */
		try {
			//getMethod 不能获取private修饰的方法，抛出异常
			/*Method m1 = c.getMethod("test");
			System.out.println(m1.invoke(test));*/
			
			//getDeclaredMethod能够获取private方法，需要setAccessible(true)才能访问
			/*Method m2 = c.getDeclaredMethod("test");
			m2.setAccessible(true);
			System.out.println(m2.invoke(test));*/
			
			//以下两种方式都能反射得到方法，，传数组时只能是new Object[]不能是new int[],否则异常
			/*//Method m3 = c.getMethod("print", int.class, int.class);
			//System.out.println(m3.invoke(test, 20, 30));
			
			Method m3 = c.getMethod("print", new Class[]{int.class, int.class});
			System.out.println(m3.invoke(test, new Object[]{20,30}));*/
			
			Method m3 = c.getMethod("print", new Class[]{String.class, String.class});
			System.out.println(m3.invoke(test, new Object[]{"20","30"}));
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class Test{
	private void test(){
		System.out.println("test private");
	}
	
	public void print(){
		System.out.println("hello world");
	}
	
	public int print(int a, int b){
		System.out.println(a + b);
		return a + b;
	}
	
	public void print(String a, String b){
		System.out.println(a.length() + b);
	}
}
