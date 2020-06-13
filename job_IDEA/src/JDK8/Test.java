package JDK8;

public class Test implements InterfacesMethods,InterfacesMethods2{
	//InterfacesMethods,InterfacesMethods2各有一个默认的方法say，实现类强制重写
	@Override
	public void say() {

	}

	@Override
	public void sayhello1() {
		// TODO Auto-generated method stub
		System.out.println("the son say hello");
	}

	public static void main(String[] args) {
		//测试InterfaceMethods类
		Test test = new Test();
		test.sayhello1();

		//测试FunctionInterface类
		// 理解位输入的haha变成了后面的函数
		FunctionInterface<String, Integer> fun = (haha) -> Integer.valueOf(haha) + 1;
		System.out.println(fun.convert("123"));

		//方法和构造函数引用(Method and Constructor References)
		FunctionInterface<String, Integer> fun2 = Integer::valueOf;
		System.out.println(fun2.convert("456"));

		new StringBuilder();
	}

}
