package com.qun.thread;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimeTask extends TimerTask{

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Timer timer = new Timer();
		
		/**
		 * 设置5秒后执行
		 */
		/*calendar.add(Calendar.SECOND, 5);
		Date time = calendar.getTime();
		timer.schedule(new MyTimeTask(), time);*/
		
		/**
		 * 设置5秒后执行
		 */
		/*timer.schedule(new MyTimeTask(), 5000);*/
		
		/**
		 * 设置5秒延时后，1秒执行一次
		 * 下一次的执行时间点=上一次程序执行完成的时间点+间隔时间
		 */
		timer.schedule(new MyTimeTask("123"), 3000, 1000);
		
		/**
		 * 设置5秒延时后，1秒执行一次
		 * 下一次的执行时间点=上一次程序开始执行的时间点+间隔时间
		 */
		timer.scheduleAtFixedRate(new MyTimeTask("456"), 3000, 1000);
	}
	
	private String name;
	
	public MyTimeTask(String string) {
		// TODO Auto-generated constructor stub
		this.name = string;
	}

	@Override
	public void run() {
		System.out.println(name + " : Now I am timetask");
	}

}
