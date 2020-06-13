package thread.threadResult;

import org.junit.Test;

/**
 * 演示如何处理线程的返回值
 * 主线程等待法
 * @author Xudong Zhang
 *
 */
public class WaitMain implements Runnable{
	private String name;
	 
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "zhang san";
    }
    
    //正常运行，因为子线程运行需要一段时间，因此，name的赋值没有运行到主线程就打印了name = null
    @Test
    public void test1() {
    	WaitMain cw = new WaitMain();
        Thread t = new Thread(cw);
        t.start();
        System.out.println("name: " + cw.name);
    }
    //等待主线程运行完，效率低
    @Test
    public void test2() throws InterruptedException {
    	WaitMain cw = new WaitMain();
        Thread t = new Thread(cw);
        t.start();
        while (cw.name == null){
            Thread.sleep(100);
        }
        System.out.println(cw.name);
        
    }
}
