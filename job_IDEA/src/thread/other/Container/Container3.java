package thread.other.Container;
/**
 * ʵ�������̣߳��߳�һ��������������֣����������������Ĵ�С��������Ϊ5��ʱ����ʾ���ر��߳�
 * ֻ��ʹ��add size ��������
 * @author Xudong Zhang
 *
 */

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Container3 {
	volatile ArrayList list = new ArrayList();//t2�̶߳�t1�ɼ�
	
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
				System.out.println(Thread.currentThread().getName()+"��ʼ����");
				if(c.size()!=5) {
					try {
						lock.wait();//�ͷ������߳���ͣ
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("�߳̽�����");
			}
		},"t2").start();
		
		new Thread(()->{
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					c.add(lock);
					System.out.println("add"+i);
					if(c.size() == 5) {
						lock.notify();//���������������ͷ��������t2�ò�����
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
	 * wait notify��ʹ�ã�ͨ�������ƣ���һ���߳�����ĳ������������£��ٿ�����һ���߳�
	 * ������2�̵߳ȴ�����1�̵߳�������ִ��2��ִ��������̽�����Ч������
	 * ����notify��û���ͷ����ڵ���������2�߳�ֻ�ܵȴ�
	 */
}
