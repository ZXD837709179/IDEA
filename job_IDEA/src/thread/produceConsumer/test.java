package thread.produceConsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class test {
	public static void main(String[] args) {
		  ArrayBlockingQueue<Resource> arrayBlockingQueue = new ArrayBlockingQueue<Resource>(10); 
		  ProduceThread produceThread = new ProduceThread(arrayBlockingQueue); 
		  ConsumerThread consumerThread = new ConsumerThread(arrayBlockingQueue); 
		  new Thread(produceThread).start(); 
		  new Thread(consumerThread).start();
		 
		
		
	}
	
	
}
