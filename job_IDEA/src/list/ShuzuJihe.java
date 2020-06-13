package list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合数组的相互转换
 * @author Xudong Zhang
 *
 */
public class ShuzuJihe {
	public static void main(String[] args) {
		//数组转成集合
		Integer[] nums = {1,2,3,4,5,6};
		//List<Integer> asList = Arrays.asList(nums);
		//System.out.println(asList);
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(nums));
		System.out.println(arrayList);
		
		//集合转换成数组
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
