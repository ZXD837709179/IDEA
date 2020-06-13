package other.jvm;
//�����ջ ÿ�ε��÷�����������һ��ջ֡��������
public class StackDepth {
	private  int index = 1;
	public void call() {
		index++;
		call();
	}
	
	public static void main(String[] args) {
		StackDepth stackDepth = new StackDepth();
		try {
			stackDepth.call();
			
		} catch (Throwable e) {
			//catch ������� Throwable ������ Exception��
			//��Ϊ StackOverflowError �� OutOfMemoryError �������� Exception ������
			System.out.println("Stack deep : "+stackDepth.index);
			e.printStackTrace();
		}
	}
}
