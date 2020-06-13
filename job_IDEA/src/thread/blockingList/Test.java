package thread.blockingList;

public class Test {
	public static void main(String[] args) {
		AxinBlockQueue queue = new AxinBlockQueue(5);
		Thread t1 = new Thread(()->{
			for(int i=0;i<100;i++) {
				queue.add(i);
				System.out.println("���м���"+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
		Thread t2 = new Thread(()->{
			for(;;) {
				System.out.println("����"+queue.take());
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
	}
}	
