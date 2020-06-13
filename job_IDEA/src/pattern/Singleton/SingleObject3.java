package pattern.Singleton;

/*懒汉模式，实例化类只是占一个坑，然后在getInstance中发现位空才实例化，线程安全
* 但是每次都要方法锁，效率较低
* */
public class SingleObject3 {
	public static SingleObject3 instance =null;
	private SingleObject3(){}

	public static synchronized SingleObject3 getInstance(){
		if(instance==null){
			instance = new SingleObject3();
		}
		return instance;
	}


	public static void main(String[] args) {
		SingleObject3 instance = SingleObject3.getInstance();
		SingleObject3 instance2 = SingleObject3.getInstance();
		System.out.println(instance.hashCode() == instance2.hashCode());

	}
}
