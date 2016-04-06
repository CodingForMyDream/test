package com.qun.designPattern.Factory;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("Send Sms");
	}

}
