package thread.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * CountDownLatch,�������߳̽���ȴ�״̬,ֱ����������Ϊ0,���������̲߳Żᱻ����,
 * �Ƚ�ʵ��,���������ܸ����߳�ִ�к�Ľ��
 * 
 * Ҫ��latch.await()���������̣߳����߳���ɺ��������߳�
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
		latch.await();//�ȴ�latch�Ĵ����㹻�Ż��������
		System.out.println("after");
		pool.shutdown();
		
	}
}
