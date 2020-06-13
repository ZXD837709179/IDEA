package thread.threadResult;
/**
 * 使用Thread类的join()阻塞当前线程以等待子线程处理完毕
 * @author Xudong Zhang
 *
 */
public class ThreadJoin implements Runnable{
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
    
    public static void main(String[] args) throws InterruptedException {
		ThreadJoin threadJoin = new ThreadJoin();
		Thread thread = new Thread(threadJoin);
		thread.start();
		thread.join();//被thread线程抢先了，也就是相当于等待
		System.out.println(threadJoin.name);
	}
}
