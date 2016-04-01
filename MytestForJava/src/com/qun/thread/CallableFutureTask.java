package com.qun.thread;
/**
 * Future的get方法阻塞主线程
 * 
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main thread execute！");
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		FTask ft = new FTask();
		FTask ft2 = new FTask();
		FutureTask<Integer> futuret = new FutureTask<Integer>(ft);
		FutureTask<Integer> futuret1 = new FutureTask<Integer>(ft);
		FutureTask<Integer> futuret2 = new FutureTask<Integer>(ft2);
		
		/**
		 * 1，线程执行cancel后不能调用get获取结果
		 * 2，cancel param true立刻打断；false允许执行完成
		 * 3，线程执行完毕后调用cancel返回false
		 */
		executor.submit(futuret);
		executor.shutdown();
		System.out.println("线程刚刚启动，线程是否执行完成：" + futuret.isDone());
		Thread.sleep(100);
		System.out.println("线程执行以上睡眠时间后，取消线程：" + futuret.cancel(true));
		System.out.println(futuret.isDone());
		System.out.println(futuret.cancel(true));
		
		
		/**
		 * result3的执行结果 == 4950，result1和result2的结果不确定
		 * 得出结论：result1和result2共享线程的sum
		 */
		/*Future<Integer> result1 = executor.submit(ft);
		Future<Integer> result2 = executor.submit(ft);
		Future<Integer> result3 = executor.submit(ft2);
		executor.shutdown();
		System.out.println("线程执行结果1:" + result1.get());
		System.out.println("线程执行结果2:" + result2.get());
		System.out.println("线程执行结果3:" + result3.get());*/
		
		
		/**
		 * futuret2的执行结果 == 4950，futuret和futuret1的结果不确定
		 * 得出结论：futuret和futuret1共享线程的sum
		 */
		/*executor.submit(futuret);
		executor.submit(futuret1);
		executor.submit(futuret2);
		executor.shutdown();
		System.out.println("线程执行结果1:" + futuret.get());
		System.out.println("线程执行结果2:" + futuret1.get());
		System.out.println("线程执行结果3:" + futuret2.get());*/
				
		/**
		 * FutureTask --> RunnableFuture --> (Runnable,Future)
		 * FutureTask能够通过thread开启线程，能够submit开启线程
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
	
	private Integer sum = 0;
	
	@Override
	public Integer call() throws Exception {
		for(int i = 0; i < 100; i++){
			Thread.sleep(10);
			System.out.println("active" + i);
			sum += i;
		}
		
		return sum;
	}
	
}