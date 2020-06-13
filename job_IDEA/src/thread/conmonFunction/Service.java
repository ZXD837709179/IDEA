package thread.conmonFunction;

public class Service {
	synchronized public static void methodA() {
        try {
            System.out.println("methodA start by " + Thread.currentThread().getName()+" at time " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("methodA end by " + Thread.currentThread().getName()+" at time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void methodB() {
        try {
            System.out.println("methodB start by " + Thread.currentThread().getName() +" at time " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("methodB end by " + Thread.currentThread().getName()+" at time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public  void methodC() {
        try {
            System.out.println("methodC start by " + Thread.currentThread().getName()+" at time " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("methodC end by " + Thread.currentThread().getName()+" at time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
		Service service = new Service();
		
	}

}
