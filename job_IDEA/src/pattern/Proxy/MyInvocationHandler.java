package pattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	
	private RealSubject realSubject;
	
	public MyInvocationHandler(RealSubject realSubject) {
		super();
		this.realSubject = realSubject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用代理类");
		if(method.getName().equals("sellBooks")){
			System.out.println("调用的是卖书的方法");
			//用到了反射
			int invoke = (int)method.invoke(realSubject, args);
			return invoke;
		}else {
			System.out.println("调用的是说话的方法");
			String rel = (String)method.invoke(realSubject, args);
			return rel;
		}
		
	}

}
