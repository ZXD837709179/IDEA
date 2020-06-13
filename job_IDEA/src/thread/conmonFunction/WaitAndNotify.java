package thread.conmonFunction;
/**
 * ͨ��wait��notify�����ӡ�߳�
 * @author Xudong Zhang
 *
 */
public class WaitAndNotify {
	static int i=1;
	
	static Object mutex = new Object();
	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (mutex) {
				while(true) {
					try {
						if(i<=10&&i%2==1) {							
							mutex.notify();//notifyҪ��wait֮ǰ
							System.out.println("����:"+ i++);
							mutex.wait();		
						}else {
							mutex.notify();
							break;
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		new Thread(() -> {
			synchronized (mutex) {
				while(true) {
					try {
						if(i<=10&&i%2==0) {
							mutex.notify();
							System.out.println("ż��"+ i++);							
							mutex.wait();
						}else {
							mutex.notify();
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	
}
