package com.qun.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取类方法
 * @author 佳俊
 */
public class ReflectDemo2 {

	public static void main(String[] args) {
		Integer s = 0;
		ClassUtil.getClassConstructor(s);
	}
}

class ClassUtil{
	
	/**
	 * 获取类的方法
	 * 理解：一个成员方法就是一个Method的对象
	 */
	public static void getClassMethod(Object obj){
		Class c = obj.getClass();
		//获取类名
		System.out.println("类的全称:" + c.getName());
		System.out.println("类名:" + c.getSimpleName());
		
		/**
		 * c.getMethods() 获取所有的public类型的方法，包含继承父类的方法
		 * c.getDeclaredMethods() 获取该类本身声明的所有方法
		 */
		Method[] ms = c.getMethods();
		for(int i = 0; i < ms.length; i++){
			//获取返回值
			System.out.print(ms[i].getReturnType().getName() + " ");
			//获取方法名
			System.out.print(ms[i].getName() + "(");
			//获取参数
			Class[] params = ms[i].getParameterTypes();
			for(int j = 0; j < params.length; j++){
				System.out.print(params[j].getName() + " args" + j + (j == params.length-1 ? "" : ","));
			}
			System.out.println(")");
		}
	}
	
	/**
	 * 获取类的成员变量
	 * 理解：一个成员变量就是一个Field的对象
	 */
	public static void getClassField(Object obj){
		Class c = obj.getClass();
		//获取类名
		System.out.println("类的全程:" + c.getName());
		System.out.println("类名:" + c.getSimpleName());
		
		/**
		 * c.getFields();	获取所有的public的成员变量
		 * c.getDeclaredFields();	获取所有该类自己声明的成员变量
		 */
		Field[] fs = c.getDeclaredFields();
		for(Field field : fs){
			System.out.println(field.getType().getName() +" "+ field.getName());
		}
	}
	
	/**
	 * 获取类的构造方法
	 * 理解：一个类的构造方法就是一个Constructor的对象
	 */
	public static void getClassConstructor(Object obj){
		Class c = obj.getClass();
		//获取类名
		System.out.println("类的全程:" + c.getName());
		System.out.println("类名:" + c.getSimpleName());
		
		/**
		 * c.getConstructors();	获取所有的public的构造方法
		 * c.getDeclaredtConstructors();	获取所有该类自己声明的构造方法（推荐）
		 */
		Constructor[] cons = c.getConstructors();
		for(Constructor con : cons){
			System.out.print(con.getName() + " (");
			Class[] params = con.getParameterTypes();
			for(int j = 0; j < params.length; j++){
				System.out.print(params[j].getName() + " args" + j + (j == params.length-1 ? "" : ","));
			}
			System.out.println(")");
		}
	}
}
