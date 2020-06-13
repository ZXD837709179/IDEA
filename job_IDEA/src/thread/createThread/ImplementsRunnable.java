package thread.createThread;
/**
 * ʵ��runnable�ӿ�,ʵ�����Ķ�����Ϊtarget����thread����
 * @author Xudong Zhang
 *
 */

public class ImplementsRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"������");
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
