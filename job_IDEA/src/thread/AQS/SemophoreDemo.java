package thread.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * 	Semaphore���ź�������˼,���Կ����̵߳Ĳ�����,
 *  acqure��release����֮�����������߳���
 * @author Xudong Zhang
 *
 */
public class SemophoreDemo {
	public static void sayHello() {
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		Semaphore s = new Semaphore(5);
		for (int i = 0; i < 50; i++) {
			pool.execute(()->{
				try {
					s.acquire();
					sayHello();
					Thread.sleep(2000);
					s.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			});
		}
		pool.shutdown();
	}
}
