package pattern.Singleton;

/*静态内部类
* */
public class SingleObject5 {
	private SingleObject5(){}

	public static SingleObject5 getInstance(){
		return Holder.instance;
	}

	public static class Holder{
		public static SingleObject5 instance = new SingleObject5();
	}
}
