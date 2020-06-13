package pattern.Singleton;

/*DCL  双重检验单例
* */
public class SingleObject4 {
	//防止重排序，很重要
	public static volatile SingleObject4 instance;
	private SingleObject4(){}

	public static synchronized SingleObject4 getInstance(){
		//单例实例化之后就不用进去加锁了
		if(instance==null){
			//防止多线程下创建多个单例
			synchronized (SingleObject4.class){
				//还是多线程安全的原因
				if(instance==null){
					instance = new SingleObject4();
				}
			}
		}
		return instance;
	}


	public static void main(String[] args) {
		SingleObject4 instance = SingleObject4.getInstance();
		SingleObject4 instance2 = SingleObject4.getInstance();
		System.out.println(instance.hashCode() == instance2.hashCode());

	}
}
