package com.qun.designPattern.adapter;

public class Source1 extends WrapperOther {
	
	@Override
	public void method1() {
		System.out.println("the sourceable interface's first Sub1!");  
	}
}
