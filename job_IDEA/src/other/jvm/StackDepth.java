package other.jvm;
//虚拟机栈 每次调用方法都会申请一个栈帧会有上线
public class StackDepth {
	private  int index = 1;
	public void call() {
		index++;
		call();
	}
	
	public static void main(String[] args) {
		StackDepth stackDepth = new StackDepth();
		try {
			stackDepth.call();
			
		} catch (Throwable e) {
			//catch 捕获的是 Throwable 而不是 Exception。
			//因为 StackOverflowError 和 OutOfMemoryError 都不属于 Exception 的子类
			System.out.println("Stack deep : "+stackDepth.index);
			e.printStackTrace();
		}
	}
}
