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
        //task.isDone()�ж��߳��Ƿ���ɣ�Ҫ��ס
        if(!task.isDone()){
            System.out.println("����û����ɣ���ȴ�");
        }
        System.out.println("���񷵻أ�" + task.get());
    }
    
    @Test
    public void test2() {
    	MyCallback callbale = new MyCallback();
    	ExecutorService executorService = Executors.newFixedThreadPool(2);
          //ִ�����񲢻�ȡFuture����
          Future<String> future = executorService.submit(callbale);
          try {
              String result =  future.get();
              System.out.println("result:" + result);
          }catch (Exception e){}
          finally {
              //�ر��̳߳�
              executorService.shutdown();
          }
    }
}