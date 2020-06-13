package thread.forkJoin;

import java.util.Vector;
import java.util.concurrent.RecursiveTask;
//fork-join将大人物分割成子任务再合并
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
			System.out.println("执行计算任务，计算    " + start + "到 " + end + "的和  ，结果是：" + sum + "   执行此任务的线程：" + Thread.currentThread().getName());
			return sum;
		}else {//任务过大，需要切割
			 System.out.println("任务过大，切割的任务：  " + start + "加到 " + end + "的和       执行此任务的线程：" + Thread.currentThread().getName());
	         int middle = (start + end) / 2;
	         CountTask countTask = new CountTask(start, middle);
	         CountTask countTask2 = new CountTask(middle+1, end);
	         //执行子任务
	         countTask.fork();
	         countTask2.fork();
	         //合并子任务
	         //invokeAll(countTask,countTask2);
	         return countTask.join()+countTask2.join();
	         
	        

		}
		
	}

}
