package com.qun.designPattern.adapter;

/**
 * @author xujian_pc
 * 类的适配器模式
 */
public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");  
	}
	
	public static void main(String[] args) {  
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }  
}
