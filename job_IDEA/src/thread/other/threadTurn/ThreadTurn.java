package thread.other.threadTurn;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/12 23:01
 * @description: 两个线程交替打印奇偶数
 */
public class ThreadTurn implements Runnable {
    int i = 0;
    public final Object lock = new Object();
    @Override
    public void run() {
        synchronized (lock){
            while(i<=100){
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName()+" : "+i++);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notifyAll();
        }
    }


    public static void main(String[] args) {
        //一个对象放到多个Thread中就可以了
        ThreadTurn threadTurn = new ThreadTurn();
        Thread thread1 = new Thread(threadTurn,"偶数");
        Thread thread2 = new Thread(threadTurn,"奇数");

        thread1.start();
        thread2.start();
    }
}
