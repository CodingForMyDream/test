package com.qun.thread;
/**
 * Future的get方法阻塞主线程
 * 
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main thread execute！");
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		FTask ft = new FTask();		
		FutureTask<Integer> futuret = new FutureTask<Integer>(ft);
		/**
		 * FutureTask --> RunnableFuture --> (Runnable,Future)
		 * FutureTask能够通过thread开启线程，能够submit开启线程
		 * Future接口只能通过submit
		 */
		/*new Thread(futuret).start();
		System.out.println("线程执行结果" + futuret.get());*/
		
		/**
		 * submit的参数result没有被赋值返回，打印不出任何结果
		 */
		/*Integer result = 10;
		executor.submit(futuret, result);
		executor.shutdown();
		System.out.println("线程执行结果" + futuret.get());
		System.out.println(result);*/
		
		/**
		 * 线程没有被提交一直阻塞
		 */
		/*System.out.println("我没有被阻塞");
		System.out.println("线程执行结果" + futuret.get());*/
		
		System.out.println("main thread execute over！");
	}

}

class FTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 0; i < 100; i++){
			sum += i;
		}
		return sum;
	}
	
}