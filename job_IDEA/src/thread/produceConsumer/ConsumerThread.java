package thread.produceConsumer;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable{
	BlockingQueue<Resource> queue;
	
	//构造方法
	public ConsumerThread(BlockingQueue<Resource> queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			Resource rs;
			try {
				while(!(rs = queue.take()).getName().equals("exit")) {
					Thread.sleep(1000);
					System.out.println("消费"+rs.getName());
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	
	
}
