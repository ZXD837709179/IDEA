package thread.produceConsumer;

import java.util.concurrent.BlockingQueue;

public class ProduceThread implements Runnable{
	BlockingQueue<Resource> queue;//阻塞队列,方法take,put
	
	public ProduceThread(BlockingQueue<Resource> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		//生产
		for (int i = 0; i < 100; i++) {
			Resource resource = new Resource("资源"+i);
			
			try {
				Thread.sleep(1000);
				queue.put(resource);
				System.out.println("生产了"+resource.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//添加退出消息
		Resource resource = new Resource("exit");
		try {
			queue.put(resource);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
