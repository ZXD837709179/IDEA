package other.jvm;

public class LoadOrder {

	public static LoadOrder t1 = new LoadOrder();
	public static LoadOrder t2 = new LoadOrder();
	{
		System.out.println("�Ǿ�̬��");
	}
	
	static {
		System.out.println("��̬�����");
	}
	
	
	public static void main(String[] args) {
		LoadOrder loadOrder = new LoadOrder();
			
	}
}
