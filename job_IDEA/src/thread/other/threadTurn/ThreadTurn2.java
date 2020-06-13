package thread.other.threadTurn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/12 23:01
 * @description: 三个线程交替打印ABC各十次, 不能只用wait和notify了，这样子只会两个线程交替使用
 */
public class ThreadTurn2 {
    public static ReentrantLock lock = new ReentrantLock();
    //注意，是lock对象创建的newCondition
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            try{
                lock.lock();

                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionB.signal();
                    conditionA.await();//给当前条件conditionB
                }
                //必须加，否则最后这个线程结束了其他的依然处于waiting的状态
                conditionB.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    public static class ThreadB implements Runnable {
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    conditionC.signal();
                    System.out.print(Thread.currentThread().getName());
                    conditionB.await();
                }
                //conditionC.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static class ThreadC implements Runnable {
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    conditionA.signal();
                    System.out.println(Thread.currentThread().getName());
                    conditionC.await();
                }
                //conditionA.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();
        Thread thread1 = new Thread(threadA, "A");
        Thread thread2 = new Thread(threadB, "B");
        Thread thread3 = new Thread(threadC, "C");

        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        System.out.println();
        System.out.println("thread1"+thread1.getState());
        System.out.println("thread2"+thread2.getState());
        System.out.println("thread3"+thread3.getState());
    }

}
