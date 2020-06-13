package thread.conmonFunction;

import org.junit.Test;

public class Interrupte {
	
	
	@Test
	public void test1() throws InterruptedException {
		 Thread thread = new Thread(() -> {
		        while (true) {
		            // 响应中断
		            if (Thread.currentThread().isInterrupted()) {
		                System.out.println("Java技术栈 线程被中断，程序退出。");
		                return;
		            }

		            try {
		                Thread.sleep(1);
		            } catch (InterruptedException e) {
		                System.out.println("Java技术栈线程休眠被中断，程序退出。");
		            }
		        }
		    });
		 
		    thread.start();
		    Thread.sleep(2000);
		    thread.interrupt();	
	}
	
}
