package thread.createThread;
/**
 * 继承thread类可以创建线程
 * @author Xudong Zhang
 *
 */
public class ExtendsThread extends Thread{
	//没有@overWrite标识
	public void run() {
		System.out.println(Thread.currentThread().getName()+"启动了");
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
