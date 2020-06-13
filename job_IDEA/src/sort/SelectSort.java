package sort;

import java.util.Arrays;

/**
 * 功能描述: 选择排序 好坏的时间复杂度都是O(n*n)  空间复杂度为O(1)
 * 不稳定的排序
 * @auther: Xudong Zhang
 * @date:   2020/4/14
 */
public class SelectSort {
	public static void sort(int[] a) {
		for(int i=0; i<a.length;i++) {
			int low = i;
			
			for(int j = i+1;j<a.length;j++) {
				low = (a[low]>a[j]?j:low);
			}
			
			if (low!=i) {
				a[low] = a[low]+a[i];
				a[i] = a[low]-a[i];
				a[low] = a[low] - a[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5,9,6,7,2,3,4,1};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
