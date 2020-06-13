package pattern.Singleton;

/**
 * 功能描述:饿汉模式，上来就直接创建例子，static在类加载的时候创建,所以类加载较慢但是例子加载较快
 * @auther: Xudong Zhang
 * @date:   2020/5/14
 */
public class SingleObject {
	//自己创建，不劳烦他人
	private static SingleObject instance = new SingleObject();

	//让构造函数为private,这样该类就不会实例化,釜底抽薪,这样子才叫单例
	private SingleObject() {};

	public static SingleObject getInstance() {
		return instance;
	}
	public void showInstance() {
		System.out.println("hello single");
	}

	public static void main(String[] args) {
		SingleObject.getInstance().showInstance();
	}
}
