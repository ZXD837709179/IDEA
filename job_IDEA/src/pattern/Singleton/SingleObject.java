package pattern.Singleton;

/**
 * ��������:����ģʽ��������ֱ�Ӵ������ӣ�static������ص�ʱ�򴴽�,��������ؽ����������Ӽ��ؽϿ�
 * @auther: Xudong Zhang
 * @date:   2020/5/14
 */
public class SingleObject {
	//�Լ����������ͷ�����
	private static SingleObject instance = new SingleObject();

	//�ù��캯��Ϊprivate,��������Ͳ���ʵ����,���׳�н,�����ӲŽе���
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
