package thread.AQS;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Mutex implements Serializable{
	//��̬�ڲ��࣬�̳�AQS
    private static class Sync extends AbstractQueuedSynchronizer {
       
    	//�Ƿ���ռ��״̬
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
        
        //��״̬Ϊ0��ʱ���ȡ����CAS�����ɹ�����state״̬Ϊ1��
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
            	
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        
        //�ͷ�������ͬ��״̬��Ϊ0
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }
        //ͬ���������һϵ�и��ӵĲ��������ǽ���ָ��������
        private final Sync sync = new Sync();
        
        //��������������acquire��ģ�巽�����Ͼ��У�acquire�����������д��tryAcquire����
        public void lock() {
            sync.acquire(1);
        }
        public boolean tryLock() {
        	System.out.println("���õ�������д�ķ���");
            return sync.tryAcquire(1);
        }
        
        //�ͷ���������release��ģ�巽�����Ͼ��У�release�����������д��tryRelease������
        public void unlock() {
            sync.release(1);
        }
        public boolean isLocked() {
            return sync.isHeldExclusively();
        }
}
