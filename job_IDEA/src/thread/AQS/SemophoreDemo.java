package thread.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * 	Semaphore是信号量的意思,可以控制线程的并发数,
 *  acqure和release方法之间最多的运行线程数
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
