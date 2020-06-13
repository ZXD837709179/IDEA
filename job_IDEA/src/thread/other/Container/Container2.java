package thread.other.Container;
/**
 * 实现两个线程，线程一向容器中添加数字，容器二监视容器的大小，当容量为5的时候提示并关闭线程
 * 只能使用add size 两个方法
 * @author Xudong Zhang
 *
 */

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Container2 {
	volatile ArrayList list = new ArrayList();//t2线程对t1可见
	
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
					System.out.println(Thread.currentThread().getName()+"的容量达到了5");
					break;
				}
			}
		},"t2").start();
	}
	/**
	 * while(true)很浪费资源
	 */
}
