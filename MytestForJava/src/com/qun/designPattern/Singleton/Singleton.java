package com.qun.designPattern.Singleton;

public class Singleton {
	
	//静态内部类的静态成员变量
	private static class SingletonInstance{
		private final static Singleton INSTANCE = new Singleton();
	}
	
	
	private static Singleton getInstance(){
		return SingletonInstance.INSTANCE;
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
	}

}
