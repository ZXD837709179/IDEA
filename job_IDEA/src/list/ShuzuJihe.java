package list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����������໥ת��
 * @author Xudong Zhang
 *
 */
public class ShuzuJihe {
	public static void main(String[] args) {
		//����ת�ɼ���
		Integer[] nums = {1,2,3,4,5,6};
		//List<Integer> asList = Arrays.asList(nums);
		//System.out.println(asList);
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(nums));
		System.out.println(arrayList);
		
		//����ת��������
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
