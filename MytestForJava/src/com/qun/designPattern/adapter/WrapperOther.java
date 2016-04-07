package com.qun.designPattern.adapter;

/**
 * 接口适配器
 * 使用场景：一个接口中定义的接口没必要全部实现，定义一个abstract类实现接口，功能类继承该抽象类，试下本身需要的方法 
 * @author xujian_pc
 */
public abstract class WrapperOther implements Targetable {

	@Override
	public void method1() {
	}

	@Override
	public void method2() {
	}
	
	public static void main(String[] args) {
		Source1 s1 = new Source1();
		s1.method1();
		s1.method2();
		
		Source2 s2 = new Source2();
		s2.method1();
		s2.method2();
	}
}
