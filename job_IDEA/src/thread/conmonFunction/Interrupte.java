package thread.conmonFunction;

import org.junit.Test;

public class Interrupte {
	
	
	@Test
	public void test1() throws InterruptedException {
		 Thread thread = new Thread(() -> {
		        while (true) {
		            // ��Ӧ�ж�
		            if (Thread.currentThread().isInterrupted()) {
		                System.out.println("Java����ջ �̱߳��жϣ������˳���");
		                return;
		            }

		            try {
		                Thread.sleep(1);
		            } catch (InterruptedException e) {
		                System.out.println("Java����ջ�߳����߱��жϣ������˳���");
		            }
		        }
		    });
		 
		    thread.start();
		    Thread.sleep(2000);
		    thread.interrupt();	
	}
	
}
