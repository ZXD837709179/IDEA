package thread.threadResult;

import org.junit.Test;

import java.util.concurrent.*;

//
public class MyCallback implements Callable<String>{
	 
    @Override
    public String call() throws Exception {
        String value = "nick";
        System.out.println("Read to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
    
    @Test
    public void test1() throws InterruptedException, ExecutionException {
    	FutureTask<String> task = new FutureTask<String>(new MyCallback());
        new Thread(task).start();
        //task.isDone()判断线程是否完成，要记住
        if(!task.isDone()){
            System.out.println("任务没有完成，请等待");
        }
        System.out.println("任务返回：" + task.get());
    }
    
    @Test
    public void test2() {
    	MyCallback callbale = new MyCallback();
    	ExecutorService executorService = Executors.newFixedThreadPool(2);
          //执行任务并获取Future对象
          Future<String> future = executorService.submit(callbale);
          try {
              String result =  future.get();
              System.out.println("result:" + result);
          }catch (Exception e){}
          finally {
              //关闭线程池
              executorService.shutdown();
          }
    }
}