package thread.myThreadPool;

import java.util.List;

public interface ThreadPool {
	void execute(Runnable task);
	void execute(Runnable[] task);
	void execute(List<Runnable> task);
	//返回执行任务的个数
	int getExecuteTaskNumber();
	//返回任务队列长度
	int getWaitTaskNumber();
	//返回工作线程数
	int getWorkThreadNmber();
	
	//关闭线程池
	void destroy();
}
