package thread.other.Container;
/**
 * 实现两个线程，线程一向容器中添加数字，容器二监视容器的大小，当容量为5的时候提示并关闭线程
 * 只能使用add size 两个方法
 * @author Xudong Zhang
 *
 */

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Container5 {
	volatile ArrayList list = new ArrayList();//t2线程对t1可见
	
	public void add(Object c) {
		list.add(c);	
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		Container5 c = new Container5();
		Object lock = new Object();
		CountDownLatch latch = new CountDownLatch(1);
		new Thread(() -> {
			
			System.out.println(Thread.currentThread().getName() + "开始启动");
			if (c.size() != 5) {
				try {
					latch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			System.out.println("线程结束了");

		}, "t2").start();

		new Thread(() -> {

			for (int i = 0; i < 10; i++) {
				c.add(lock);
				System.out.println("add" + i);
				if (c.size() == 5) {
					latch.countDown();	
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		},"t1").start();
		
		
		
	}
	/**
	 *解决了上一个的问题，但是比较麻烦，一会释放一会等待的
	 *可以简化，使用门闩latch
	 */
}
