package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * ͨ�������ȡ������Ժͷ���
 * @author Xudong Zhang
 *
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception{
		Class rc = Class.forName("reflect.Robot");
		
		Robot r = (Robot)rc.newInstance();//����rc��ʵ����newInstance�Ĵ���������Object������Ҫǿת
		System.out.println("class name is "+rc.getName());//���ص�������
		//r.sayHi("Tom");//��Ͳ��Ƿ�����,public���εķ��������Դ�ӡ
		
		//getDeclaredMethod���Ի�ù�����˽�еķ��������ǲ��ܻ�ü̳еķ������ӿڵķ���
		Method hello = rc.getDeclaredMethod("sayHello", String.class);//sayHello  ����String�Ĳ��������String.class
		hello.setAccessible(true);//˽�еķ���Ҫ����
		Object str = hello.invoke(r, "Bob");//Ҫ�������ʵ��
		System.out.println("sayHello result is "+str);
		
		Method hi = rc.getMethod("sayHi", String.class);
		hi.invoke(r, "welcome");
		

		Field name = rc.getDeclaredField("name");
		name.setAccessible(true);
		name.set(r, "Alice");
		hi.invoke(r, "welcome");
		
		//��ȡ���ж���ķ���
		Method[] methods = rc.getDeclaredMethods();
		for (Method method : methods) {
			String name2 = method.getName();
			System.out.println(name2);
		}

		ClassLoader classLoader = Robot.class.getClassLoader();
		System.out.println(classLoader.toString());
		System.out.println(classLoader.getParent().toString());
		System.out.println(int.class.getClassLoader());
	}
}
