package other.jvm;

public class LoadOrder {

	public static LoadOrder t1 = new LoadOrder();
	public static LoadOrder t2 = new LoadOrder();
	{
		System.out.println("·Ç¾²Ì¬¿é");
	}
	
	static {
		System.out.println("¾²Ì¬´úÂë¿é");
	}
	
	
	public static void main(String[] args) {
		LoadOrder loadOrder = new LoadOrder();
			
	}
}
