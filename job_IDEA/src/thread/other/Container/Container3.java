package thread.other.Container;
/**
 * 实现两个线程，线程一向容器中添加数字，容器二监视容器的大小，当容量为5的时候提示并关闭线程
 * 只能使用add size 两个方法
 * @author Xudong Zhang
 *
 */

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Container3 {
	volatile ArrayList list = new ArrayList();//t2线程对t1可见
	
	public void add(Object c) {
		list.add(c);	
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		Container3 c = new Container3();
		Object lock = new Object();
		new Thread(()-> {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+"开始启动");
				if(c.size()!=5) {
					try {
						lock.wait();//释放锁，线程暂停
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("线程结束了");
			}
		},"t2").start();
		
		new Thread(()->{
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					c.add(lock);
					System.out.println("add"+i);
					if(c.size() == 5) {
						lock.notify();//唤醒锁，并不会释放锁，因此t2拿不到锁
					}
					try {
						TimeUnit.SECONDS.sleep(1);				
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
				
		},"t1").start();
		
		
	}
	/**
	 * wait notify的使用，通过锁机制，在一个线程满足某个条件的情况下，再开启另一个线程
	 * 避免了2线程等待满足1线程的条件才执行2，执行完就立刻结束，效率增加
	 * 但是notify并没有释放现在的锁，导致2线程只能等待
	 */
}
