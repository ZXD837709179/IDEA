package thread.forkJoin;

import java.util.Vector;
import java.util.concurrent.RecursiveTask;
//fork-join��������ָ���������ٺϲ�
public class CountTask extends RecursiveTask<Integer>{
	private static final int threshold = 2;
	private int start;
	private int end;
	
	public CountTask(int start,int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end-start)<=threshold;
		 Vector<Integer> vector = new Vector<Integer>();
		if(canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
			System.out.println("ִ�м������񣬼���    " + start + "�� " + end + "�ĺ�  ������ǣ�" + sum + "   ִ�д�������̣߳�" + Thread.currentThread().getName());
			return sum;
		}else {//���������Ҫ�и�
			 System.out.println("��������и������  " + start + "�ӵ� " + end + "�ĺ�       ִ�д�������̣߳�" + Thread.currentThread().getName());
	         int middle = (start + end) / 2;
	         CountTask countTask = new CountTask(start, middle);
	         CountTask countTask2 = new CountTask(middle+1, end);
	         //ִ��������
	         countTask.fork();
	         countTask2.fork();
	         //�ϲ�������
	         //invokeAll(countTask,countTask2);
	         return countTask.join()+countTask2.join();
	         
	        

		}
		
	}

}
