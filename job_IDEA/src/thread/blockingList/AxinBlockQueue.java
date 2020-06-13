package thread.blockingList;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AxinBlockQueue {
	//��������
	private ArrayList<Integer> container = new ArrayList<>();
	private volatile int size;
	private volatile int capacity;
	private Lock lock = new ReentrantLock();
	//Condition
	private final Condition isNull = lock.newCondition();
	private final Condition isFull = lock.newCondition();
	
	public AxinBlockQueue(int cap){
		this.capacity = cap;
	}
	
	public void add(int data) {
		try{
			lock.lock();
			while(size>=capacity) {
				try {
					System.out.println("��������");
					isFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					isFull.signal();
					e.printStackTrace();
				}
			}
			++size;
			container.add(data);
			isFull.signal();
		}finally {
			lock.unlock();
		}
		
	}
	/**
	 * ȡ��Ԫ��
	 * @return
	 */
	public int take() {
		try {
			lock.lock();
			try {
				while (size == 0) {
					System.out.println("�������п���");
					isNull.await();
				}
			} catch (Exception e) {
				isNull.signal();
				e.printStackTrace();
			}
			size--;
			int res = container.get(0);
			container.remove(0);
			isFull.signal();
			return res;
		} finally {
			lock.unlock();

		}
	}
	
	
}
