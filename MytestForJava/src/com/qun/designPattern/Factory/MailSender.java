package com.qun.designPattern.Factory;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("Send Mail");
	}

}
