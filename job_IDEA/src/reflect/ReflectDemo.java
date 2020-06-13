package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 通过反射获取类的属性和方法
 * @author Xudong Zhang
 *
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception{
		Class rc = Class.forName("reflect.Robot");
		
		Robot r = (Robot)rc.newInstance();//创建rc的实例，newInstance的创建对象是Object所以需要强转
		System.out.println("class name is "+rc.getName());//返回的是类名
		//r.sayHi("Tom");//这就不是反射了,public修饰的方法，可以打印
		
		//getDeclaredMethod可以获得公共的私有的方法，但是不能获得继承的方法，接口的方法
		Method hello = rc.getDeclaredMethod("sayHello", String.class);//sayHello  接受String的参数，因此String.class
		hello.setAccessible(true);//私有的方法要设置
		Object str = hello.invoke(r, "Bob");//要传入对象实例
		System.out.println("sayHello result is "+str);
		
		Method hi = rc.getMethod("sayHi", String.class);
		hi.invoke(r, "welcome");
		

		Field name = rc.getDeclaredField("name");
		name.setAccessible(true);
		name.set(r, "Alice");
		hi.invoke(r, "welcome");
		
		//获取所有定义的方法
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
