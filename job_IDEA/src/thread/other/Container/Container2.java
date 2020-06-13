package thread.other.Container;
/**
 * ʵ�������̣߳��߳�һ���������������֣����������������Ĵ�С��������Ϊ5��ʱ����ʾ���ر��߳�
 * ֻ��ʹ��add size ��������
 * @author Xudong Zhang
 *
 */

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Container2 {
	volatile ArrayList list = new ArrayList();//t2�̶߳�t1�ɼ�
	
	public void add(Object c) {
		list.add(c);	
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		Container2 c = new Container2();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add"+i);
				try {
					TimeUnit.SECONDS.sleep(1);				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}	
		},"t1").start();
		
		new Thread(()-> {
			while (true) {
				if(c.size() == 5) {
					System.out.println(Thread.currentThread().getName()+"�������ﵽ��5");
					break;
				}
			}
		},"t2").start();
	}
	/**
	 * while(true)���˷���Դ
	 */
}