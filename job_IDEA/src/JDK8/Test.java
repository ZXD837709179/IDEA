package JDK8;

public class Test implements InterfacesMethods,InterfacesMethods2{
	//InterfacesMethods,InterfacesMethods2����һ��Ĭ�ϵķ���say��ʵ����ǿ����д
	@Override
	public void say() {

	}

	@Override
	public void sayhello1() {
		// TODO Auto-generated method stub
		System.out.println("the son say hello");
	}

	public static void main(String[] args) {
		//����InterfaceMethods��
		Test test = new Test();
		test.sayhello1();

		//����FunctionInterface��
		// ���λ�����haha����˺���ĺ���
		FunctionInterface<String, Integer> fun = (haha) -> Integer.valueOf(haha) + 1;
		System.out.println(fun.convert("123"));

		//�����͹��캯������(Method and Constructor References)
		FunctionInterface<String, Integer> fun2 = Integer::valueOf;
		System.out.println(fun2.convert("456"));

		new StringBuilder();
	}

}
