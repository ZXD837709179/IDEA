package pattern.Proxy;

import java.lang.reflect.Proxy;

public class Test {
	/**
	 * ����ģʽ����
	 * @param args
	 */
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
		Subject proxyClass = (Subject)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);
		proxyClass.sellBooks();

	    //proxyClass.speak();

	}
}
