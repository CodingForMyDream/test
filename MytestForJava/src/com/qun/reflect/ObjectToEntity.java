package com.qun.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.qun.myAnnotation.Apple;

/**
 *	通过反射快速封装方法
 */
public class ObjectToEntity {

    /** 
     * @param object 需要进行属性封装的对象 
     * @param fields 需要进行封装的属性 
     * @param params 需要进行设置的值 
     */  
    public static void ObjectToEntityByInvoke(Object object, String[] fields,  Object[] params) throws Exception{  
        Class<?> cl = object.getClass();  
        for (int i = 0; i < fields.length; i++) {  
            StringBuffer buffer = new StringBuffer();  
            Field field = cl.getDeclaredField(fields[i]);  
            Class<?> paramType = field.getType();  
            buffer.append("set");  
            buffer.append(fields[i].substring(0, 1).toUpperCase());  
            buffer.append(fields[i].substring(1));  
            Method method = cl.getDeclaredMethod(buffer.toString(), paramType);  
            method.invoke(object, params[i]);  
        }  
    }
    
    /** 
     * @param object 需要进行属性封装的对象 
     * @param fields 需要进行封装的属性 
     * @param params 需要进行设置的值 
     */  
    public static void ObjectToEntityBySet(Object object, String[] fields,  Object[] params) throws Exception {  
        Class<?> cl = object.getClass();  
        for (int i = 0; i < fields.length; i++) {
        	Field f = cl.getDeclaredField(fields[i]);
        	f.setAccessible(true);
        	f.set(object, params[i]);
        }  
    }
    
    public static void main(String[] args) {  
    	Apple apple = new Apple();  
        String[] method = { "appleName", "appleColor"};  
        Object[] param = { "hongfushi", "red"};  
        try {
			//ObjectToEntityByInvoke(apple, method, param);
			ObjectToEntityBySet(apple, method, param);
		} catch (Exception e) {
			e.printStackTrace();
		}  
        System.out.println(apple);  
    } 
	
}
