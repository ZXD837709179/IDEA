package thread.createThread;
/**
 * �̳�thread����Դ����߳�
 * @author Xudong Zhang
 *
 */
public class ExtendsThread extends Thread{
	//û��@overWrite��ʶ
	public void run() {
		System.out.println(Thread.currentThread().getName()+"������");
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+"---"+i);
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread td = new ExtendsThread();
		td.setName("haha");
		Thread td2 = new ExtendsThread();
		td2.setName("hehe");
		td.start();
		td2.start();
	}
}
