package pattern.Singleton;

/*懒汉模式，实例化类只是占一个坑，然后在getInstance中发现位空才实例化，线程不安全*/
public class SingleObject2 {
	public static SingleObject2 instance =null;
	private SingleObject2(){}

	public static SingleObject2 getInstance(){
		if(instance==null){
			instance = new SingleObject2();
		}
		return instance;
	}


	public static void main(String[] args) {
		SingleObject2 instance = SingleObject2.getInstance();
		SingleObject2 instance2 = SingleObject2.getInstance();
		System.out.println(instance.hashCode() == instance2.hashCode());

	}
}
