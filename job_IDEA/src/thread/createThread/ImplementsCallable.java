package thread.createThread;
/**
 * 实现callable接口,可以有返回值或者处理异常
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ImplementsCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "这就是结果";
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ImplementsCallable implementsCallable = new ImplementsCallable();
		FutureTask<String> futureTask = new FutureTask<String>(implementsCallable);
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println(futureTask.get().toString());
		
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Future<String> submit = pool.submit(implementsCallable);
		System.out.println(submit.get());
	}
	
}
