package other.jvm;

public class MinorAndFull {
	/**
	 * -XX:+PrintGCDetails在run configuration的arguments配置，就可以看到新生代老年代的内存使用情况
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
		allocation1 = new byte[32000*1024];
		allocation2 = new byte[50000*1024];
		allocation3 = new byte[1000*1024];
		allocation4 = new byte[1000*1024];
		allocation5 = new byte[1000*1024];
	}
}
