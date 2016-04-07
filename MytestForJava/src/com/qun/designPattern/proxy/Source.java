package com.qun.designPattern.proxy;

public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("source method");
	}

}
