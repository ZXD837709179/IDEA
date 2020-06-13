package thread.produceConsumer;

import java.util.concurrent.BlockingQueue;

public class ProduceThread implements Runnable{
	BlockingQueue<Resource> queue;//��������,����take,put
	
	public ProduceThread(BlockingQueue<Resource> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		//����
		for (int i = 0; i < 100; i++) {
			Resource resource = new Resource("��Դ"+i);
			
			try {
				Thread.sleep(1000);
				queue.put(resource);
				System.out.println("������"+resource.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//����˳���Ϣ
		Resource resource = new Resource("exit");
		try {
			queue.put(resource);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
