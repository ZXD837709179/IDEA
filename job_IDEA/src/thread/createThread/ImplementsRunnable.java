package thread.createThread;
/**
 * 实现runnable接口,实例化的对象作为target放入thread类中
 * @author Xudong Zhang
 *
 */

public class ImplementsRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"启动了");
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+"---"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ImplementsRunnable ic = new ImplementsRunnable();
		Thread thread = new Thread(ic,"haha");
		thread.start();
	}
	
}
