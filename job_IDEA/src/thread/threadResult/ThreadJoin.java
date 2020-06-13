package thread.threadResult;
/**
 * ʹ��Thread���join()������ǰ�߳��Եȴ����̴߳������
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
		thread.join();//��thread�߳������ˣ�Ҳ�����൱�ڵȴ�
		System.out.println(threadJoin.name);
	}
}
