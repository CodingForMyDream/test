package com.qun.thread;
/**
 * shutdown和shutdownNow的调用都会使线程池不在接收新的线程
 * shutdownNow会通过interrupt中断，sleep和wait阻塞的线程会抛出异常；
 * 添加shutdown或者shutdownNow能够使得程序停止，否则程序一直显示执行状态（红点）
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Task task = new Task();
		Future<Integer> result1 = executor.submit(task);
		Future<Integer> result2 = executor.submit(task);
		Task task2 = new Task();
		Future<Integer> result3 = executor.submit(task2);
		executor.shutdown();
		//executor.shutdownNow();
		
		try {
			System.out.println("线程1执行结果：" + result1.get());
			System.out.println("线程2执行结果：" + result2.get());
			System.out.println("线程3执行结果：" + result3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("执行完毕");
	}

}

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Integer sum = 0;
		
		for (int i = 0; i < 100; i++) {
			/*Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());*/
			sum += i;
		}
		return sum;
	}

}