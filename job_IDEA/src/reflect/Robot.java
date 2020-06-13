package reflect;

public class Robot {
	private String name;
	
	public void sayHi(String helloSetence) {
		System.out.println(helloSetence+" "+name);
	}
	
	private String sayHello(String tag) {
		return "hello"+" "+tag;
	}
}
