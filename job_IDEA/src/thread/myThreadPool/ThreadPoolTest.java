package thread.myThreadPool;

import java.util.ArrayList;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPool pool = ThreadPoolManager.getThreadPool(6);
		ArrayList<Runnable> list = new ArrayList<Runnable>();
		for (int i = 0; i < 100; i++) {
			list.add(new Task());	
		}
		pool.execute(list);
		System.out.println(pool);
		pool.destroy();
		System.out.println(pool);
		
	}
	
	public static class Task implements Runnable{
		private static volatile int i=1;

		@Override
		public void run() {
			// TODO Auto-generated method stub
				System.out.println("当前处理的线程是："+Thread.currentThread().getName()+"执行任务"+(i++)+"完成");
		}
		
	}
}
