package thread.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * CyclicBarrier,ѭ������,����ڼ�����ֻ����һ�εĳ���,CyclicBarrier����ѭ�����ʹ��,
 * @author Xudong Zhang
 *
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) throws Exception {
		CyclicBarrier barrier = new CyclicBarrier(6);
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			pool.execute(()->{
				try {
					Thread.sleep(1000);
					System.out.println("before");
					Thread.sleep(1000);
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
		}
		barrier.await();//await�Ĵ����㹻�ſ���
		System.out.println("after");
		pool.shutdown();
	}
}
