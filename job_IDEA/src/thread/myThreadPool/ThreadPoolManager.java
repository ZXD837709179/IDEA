package thread.myThreadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolManager implements ThreadPool{
	//默认线程数
	private static int workNum = 5;
	
	//工作线程数组
	WorkThread[] workThreads;
	
	//执行任务的数量
	private static volatile int executeTaskNumber = 0;
	
	//任务队列
	private LinkedList<Runnable> taskQueue = new LinkedList<Runnable>();
	
	private static ThreadPoolManager threadPool;//初始化时，如果为null则新建一个pool
	
	private AtomicLong threadNum = new AtomicLong();
	
	
	//构造方法
	private ThreadPoolManager() {
		this(workNum);
	}
	
	private ThreadPoolManager(int workNum) {//有默认的线程数，如果有外界传入的线程数就用外界的线程数
		if(workNum>0){
			ThreadPoolManager.workNum = workNum;
		}
		//工作线程初始化		
		workThreads = new WorkThread[workNum];
		for(int i=0;i<ThreadPoolManager.workNum;i++) {
			workThreads[i]= new WorkThread();
            //new thread(new runnable接口实现类，线程名称)
			Thread thread = new Thread(workThreads[i], "ThreadPool-worker" +threadNum.incrementAndGet());
            
            System.out.println("初始化线程总数" + (i + 1) + "------当前线程名称是：" + thread.getName());
            thread.start();
		}
	}
	
    //获取线程池
    public static ThreadPool getThreadPool() {

        return getThreadPool(ThreadPoolManager.workNum);
    }

    public static ThreadPool getThreadPool(int workerNum) {

        if (workerNum <= 0) {
            workerNum = ThreadPoolManager.workNum;
        }

        if (threadPool == null) {
            threadPool = new ThreadPoolManager(workerNum);
        }

        return threadPool;
    }
	
	@Override
	public void execute(Runnable task) {
		synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notifyAll();
		}
	}

	@Override
	public void execute(Runnable[] tasks) {
		for (Runnable task : tasks) {
			taskQueue.add(task);
		}
		taskQueue.notify();
	}

	@Override
	public void execute(List<Runnable> tasks) {
		synchronized (taskQueue) {
			for (Runnable task : tasks) {
				taskQueue.add(task);
			}
			taskQueue.notifyAll();
		}
	}

	@Override
	public int getExecuteTaskNumber() {
		return executeTaskNumber;
	}

	@Override
	public int getWaitTaskNumber() {
		return taskQueue.size();
	}

	@Override
	public int getWorkThreadNmber() {
		return workNum;
	}

	@Override
	public void destroy() {
		while(!taskQueue.isEmpty()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		for (int i = 0; i < workNum; i++) {
			workThreads[i].stopWork();
			workThreads[i] = null;
		}
		
		threadPool = null;
		taskQueue.clear();
	}
	  @Override
	    public String toString() {
	        return "当前工作线程数：" + workNum +
	                ", 已完成任务数：" + executeTaskNumber +
	                ", 等待任务数量：" + getWaitTaskNumber();
	    }	
	
	
	//创建线程
	private class WorkThread extends Thread{
		//该线程是否有效，用于判断是否结束该线程
		private boolean isRunning = true;
		
		@Override
		public void run() {
			super.run();
		
		
			Runnable r = null;
			
			while(isRunning){
				synchronized (taskQueue) {
					//队列为空
					while(isRunning && taskQueue.isEmpty()) {
						try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//队列不为空,取出任务
					if(!taskQueue.isEmpty()) {
						r = taskQueue.remove();
					}
					if(r!=null) {
						r.run();
					}
					executeTaskNumber++;
					r = null;
					
				}
			}
		}
		
		//执行完run方法后自然结束
		public void stopWork() {
			isRunning = false;
		}
	}

}
