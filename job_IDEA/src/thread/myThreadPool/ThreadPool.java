package thread.myThreadPool;

import java.util.List;

public interface ThreadPool {
	void execute(Runnable task);
	void execute(Runnable[] task);
	void execute(List<Runnable> task);
	//����ִ������ĸ���
	int getExecuteTaskNumber();
	//����������г���
	int getWaitTaskNumber();
	//���ع����߳���
	int getWorkThreadNmber();
	
	//�ر��̳߳�
	void destroy();
}
