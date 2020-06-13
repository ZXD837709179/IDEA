package thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示CAS的ABA问题
 * @author Xudong Zhang
 *
 */
public class ABADemo {
	public static void main(String[] args) {
		defectABA();
	}
	
	public static void defectABA() {
		AtomicInteger atomicInteger = new AtomicInteger(1);
		//the thread think th
		
		Thread coreThread = new Thread(
			()->{
				final int currentValue = atomicInteger.get();
				System.out.println("current thread is"+Thread.currentThread().getName()+"-----value is "+currentValue);
				//模拟处理其他业务花费的时间
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean casResult = atomicInteger.compareAndSet(1, 2);
                System.out.println(Thread.currentThread().getName()
                        + " ------ currentValue=" + currentValue
                        + ", finalValue=" + atomicInteger.get()
                        + ", compareAndSet Result=" + casResult);
			});
		coreThread.start();
		
		Thread amateurThread = new Thread(
                () -> {
                	//由A到B
                    int currentValue = atomicInteger.get();
                    boolean casResult = atomicInteger.compareAndSet(1, 2);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);
                    //from B to A
                    currentValue = atomicInteger.get();
                    casResult = atomicInteger.compareAndSet(2, 1);
                    System.out.println(Thread.currentThread().getName()
                            + " ------ currentValue=" + currentValue
                            + ", finalValue=" + atomicInteger.get()
                            + ", compareAndSet Result=" + casResult);
                }
        );
        amateurThread.start();
	}
}
