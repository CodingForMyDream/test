package com.qun.designPattern.Factory;

public class SendStaticFactory {
	
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
	
	public static void main(String[] args) {
		
		SendStaticFactory.produceMail().send();
	}
	
}

