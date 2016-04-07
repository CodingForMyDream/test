package com.qun.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo4 {

	public static void main(String[] args) {
		
		List list1 = new ArrayList();
		List<String> list2 = new ArrayList<String>();
		
		Class c1 = list1.getClass();
		Class c2 = list2.getClass();
		
		/**
		 * 打印相同的结果说明，list1和list2的类类型是相同
		 * 结论：集合的泛型添加集合的操作只存在编译期的验证，绕过编译器能够写入泛型以外的值
		 * 但是，集合不能遍历
		 */
		System.out.println(c1 == c2);
		
		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list2, 20);
			System.out.println(list2);
			
			/**
			 * 添加泛型以外的值的集合不能遍历
			 */
			//遍历集合抛出异常Interger cannot be cast to String
			/*for(String s : list2){
				System.out.println(s);
			}*/
			
			//遍历集合抛出异常Interger cannot be cast to String
			/*for(int i = 0; i < list2.size(); i++){
				System.out.println(list2.get(i));
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
