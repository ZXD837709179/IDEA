package thread.AQS;

import java.util.concurrent.CyclicBarrier;

public class TestMutex {
	private static CyclicBarrier barrier = new CyclicBarrier(31);
    private static int a = 0;
    private static  Mutex mutex = new Mutex();

    public static void main(String []args) throws Exception {
        //˵��:��������30���̣߳�ÿ���̶߳�i�Լ�10000�Σ�ͬ�������Ļ������ս��ӦΪ300000��
        //δ����ǰ
        for(int i=0;i<30;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        increment1();//û��ͬ����ʩ��a++��
                    }
                    try {
                        barrier.await();//��30���߳��ۼ����
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        barrier.await();
        System.out.println("����ǰ��a="+a);
        //������
        barrier.reset();//����CyclicBarrier
        a=0;
        
        for(int i=0;i<30;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        increment2();//a++����Mutex����ͬ������
                    }
                    try {
                        barrier.await();//��30���߳��ۼ����
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        barrier.await();
        System.out.println("������a="+a);
    }
    /**
     * û��ͬ����ʩ��a++
     * @return
     */
    public static void increment1(){
        a++;
    }
    /**
     * ʹ���Զ����Mutex����ͬ�������a++
     */
    public static void increment2(){
        mutex.lock();
        a++;
        mutex.unlock();
    }
    
}
