package selfIOC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

public class SimpleIOCTest {
	@Test
	public void getBean() {
		// TODO Auto-generated method stub
		InputStream resourceAsStream = SimpleIOC.class.getClassLoader().getResourceAsStream("ioc.xml");
		SimpleIOC bf = new SimpleIOC(resourceAsStream);
		Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
		Car car = (Car)bf.getBean("car");
		System.out.println(car);		
	}
	
	
}
