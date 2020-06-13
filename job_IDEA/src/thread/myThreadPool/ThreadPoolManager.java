package thread.myThreadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolManager implements ThreadPool{
	//Ĭ���߳���
	private static int workNum = 5;
	
	//�����߳�����
	WorkThread[] workThreads;
	
	//ִ�����������
	private static volatile int executeTaskNumber = 0;
	
	//�������
	private LinkedList<Runnable> taskQueue = new LinkedList<Runnable>();
	
	private static ThreadPoolManager threadPool;//��ʼ��ʱ�����Ϊnull���½�һ��pool
	
	private AtomicLong threadNum = new AtomicLong();
	
	
	//���췽��
	private ThreadPoolManager() {
		this(workNum);
	}
	
	private ThreadPoolManager(int workNum) {//��Ĭ�ϵ��߳������������紫����߳������������߳���
		if(workNum>0){
			ThreadPoolManager.workNum = workNum;
		}
		//�����̳߳�ʼ��		
		workThreads = new WorkThread[workNum];
		for(int i=0;i<ThreadPoolManager.workNum;i++) {
			workThreads[i]= new WorkThread();
            //new thread(new runnable�ӿ�ʵ���࣬�߳�����)
			Thread thread = new Thread(workThreads[i], "ThreadPool-worker" +threadNum.incrementAndGet());
            
            System.out.println("��ʼ���߳�����" + (i + 1) + "------��ǰ�߳������ǣ�" + thread.getName());
            thread.start();
		}
	}
	
    //��ȡ�̳߳�
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
	        return "��ǰ�����߳�����" + workNum +
	                ", �������������" + executeTaskNumber +
	                ", �ȴ�����������" + getWaitTaskNumber();
	    }	
	
	
	//�����߳�
	private class WorkThread extends Thread{
		//���߳��Ƿ���Ч�������ж��Ƿ�������߳�
		private boolean isRunning = true;
		
		@Override
		public void run() {
			super.run();
		
		
			Runnable r = null;
			
			while(isRunning){
				synchronized (taskQueue) {
					//����Ϊ��
					while(isRunning && taskQueue.isEmpty()) {
						try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//���в�Ϊ��,ȡ������
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
		
		//ִ����run��������Ȼ����
		public void stopWork() {
			isRunning = false;
		}
	}

}
