package thread.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * CountDownLatch,可以让线程进入等待状态,直到计数器减为0,被阻塞的线程才会被唤醒,
 * 比较实用,常用来汇总各个线程执行后的结果
 * 
 * 要有latch.await()，阻塞主线程，子线程完成后运行主线程
 * @author Xudong Zhang
 *
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			pool.execute(()->{
				try {
					Thread.sleep(1000);
					System.out.println("before");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
			});
		}
		latch.await();//等待latch的次数足够才会继续运行
		System.out.println("after");
		pool.shutdown();
		
	}
}
