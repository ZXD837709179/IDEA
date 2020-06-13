package JDK8;
/**
 * JDK8新增使用 default 关键字向接口添加非抽象方法实现
 * @author Xudong Zhang
 *
 */
public interface InterfacesMethods {
	default void say() {
		System.out.println("what a strange");
	}
	
	public void sayhello1();
}
