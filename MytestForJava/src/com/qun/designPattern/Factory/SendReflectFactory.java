package com.qun.designPattern.Factory;

public class SendReflectFactory {
	
	public static Sender produce(String className) {
		Class c = null;
		Sender sd = null;
		try {
			c = Class.forName("com.qun.designPattern.Factory." + className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			sd =  (Sender) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return sd;
		
	}
	
	public static void main(String[] args) {
		
		SendReflectFactory.produce("SmsSender").send();
	}
	
}

