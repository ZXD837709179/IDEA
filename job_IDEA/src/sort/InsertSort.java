package sort;

import java.util.Arrays;

/**
 * 插入排序，从第一个元素开始，一次与前面的进行比较，插到一个合适的地方
 * 稳定的排序，复杂度为 n*n,最好的时间复杂度为n
 * @author Xudong Zhang
 *
 */
public class InsertSort {
	//移位法
	public static void sort(int[] a) {
		if(a==null || a.length==0)return;//这是两种情况，为空和为null
		
		for(int i=1;i<a.length;i++) {
			int j = i-1;
			int tmp = a[i];
			while(j>=0 && a[j]>tmp) {//a[j]>tmp && j>=0是错误的，先判断存在，再判断才能在的意义
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = tmp;
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {5,4,9,6,7,2,3};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
