package com.qun.thread;
/**
 * 线程中不存在sleep，wait等阻塞线程的操作；interrupt的调用不会出现异常；否则抛出InterruptedException
 * 
 * interrupt的调用时的线程被打断，不影响程序的最后执行结果（能打印"线程执行完毕"）
 * stop中断线程，以后的操作不能继续执行（不能打印"线程执行完毕"）
 *
 */
public class InterruptStop {
	public static void main(String[] args) {
		InterruptThread it = new InterruptThread();
		it.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		it.interrupt();
		//it.stop();
	}

}

class InterruptThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("线程执行开始");
		for(int i = 0; i < 100000; i++){
			System.out.println("线程执行中");
		}
		System.out.println("线程执行完毕");
	}
}