package thread.other.Container;
/**
 * ʵ�������̣߳��߳�һ��������������֣����������������Ĵ�С��������Ϊ5��ʱ����ʾ���ر��߳�
 * ֻ��ʹ��add size ��������
 * @author Xudong Zhang
 *
 */

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Container5 {
	volatile ArrayList list = new ArrayList();//t2�̶߳�t1�ɼ�
	
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
			
			System.out.println(Thread.currentThread().getName() + "��ʼ����");
			if (c.size() != 5) {
				try {
					latch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			System.out.println("�߳̽�����");

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
	 *�������һ�������⣬���ǱȽ��鷳��һ���ͷ�һ��ȴ���
	 *���Լ򻯣�ʹ������latch
	 */
}
