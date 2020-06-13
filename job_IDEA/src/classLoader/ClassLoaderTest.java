package classLoader;

import java.lang.reflect.Method;

public class ClassLoaderTest {
	public static void main(String[] args) {
		MyClassLoader myClassLoader = new MyClassLoader("D:");
		try {
			Class c = myClassLoader.loadClass("classLoader.Test");
			if(c!=null) {
				Object obj = c.newInstance();
				
				Method methd = c.getDeclaredMethod("sayHi", null);
				methd.invoke(obj, null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
