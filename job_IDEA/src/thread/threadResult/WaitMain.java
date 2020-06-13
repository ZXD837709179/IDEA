package thread.threadResult;

import org.junit.Test;

/**
 * ��ʾ��δ����̵߳ķ���ֵ
 * ���̵߳ȴ���
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
    
    //�������У���Ϊ���߳�������Ҫһ��ʱ�䣬��ˣ�name�ĸ�ֵû�����е����߳̾ʹ�ӡ��name = null
    @Test
    public void test1() {
    	WaitMain cw = new WaitMain();
        Thread t = new Thread(cw);
        t.start();
        System.out.println("name: " + cw.name);
    }
    //�ȴ����߳������꣬Ч�ʵ�
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
