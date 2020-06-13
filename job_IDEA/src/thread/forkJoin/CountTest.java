package thread.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class CountTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool forkJoinPool = new ForkJoinPool(3);
		CountTask task = new CountTask(1, 12);
		//ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
		int submit = forkJoinPool.invoke(task);
		System.out.println("最终的计算结果是："+submit);
	}
}
