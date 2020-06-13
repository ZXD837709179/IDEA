package list;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ArraylistYuanMa {
	public static void main(String[] args) {
		//new ArrayList<>(-1);//Illegal Capacity: -1
		//   3>>1   ：3这个数右移一位，变为原来的一半
		//   3<<1   ：3这个数左移一位，变为原来的两倍
		
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		//Integer.MAX_VALUE   2147483647
		//int i = 2147483647;System.out.println(i+1);  =>-2147483648   i+2=>-2147483647
		float i = 1.0f - 0.9f;
		float j = 0.9f - 0.8f;
		System.out.println(i >= j);
		
		HashMap<String,String> hashMap = new HashMap<String, String>();
		hashMap.put("haha", "kaixin");
		hashMap.put("haha2", "kaixin2");
		hashMap.put("haha3", "kaixin3");
		hashMap.put("haha4", "kaixin4");
		hashMap.put("haha5", "kaixin5");
		hashMap.put("haha6", "kaixin6");
		for (Iterator<String> iterator = hashMap.keySet().iterator(); iterator.hasNext();) {
			String integer = (String) iterator.next();
			System.out.println(integer);
		}

	}
}
