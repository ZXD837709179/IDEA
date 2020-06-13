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
		System.out.println("���ô�����");
		if(method.getName().equals("sellBooks")){
			System.out.println("���õ�������ķ���");
			//�õ��˷���
			int invoke = (int)method.invoke(realSubject, args);
			return invoke;
		}else {
			System.out.println("���õ���˵���ķ���");
			String rel = (String)method.invoke(realSubject, args);
			return rel;
		}
		
	}

}
