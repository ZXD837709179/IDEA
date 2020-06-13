package sort;

import java.util.Arrays;
/**
 * 希尔排序，不稳定排序算法，希尔排序第一个突破O(n*n)的排序算法，平均复杂度n^1.3
 * 最好的时间复杂度为n,最差为n^2；
 * 是简单插入排序的改进版
 * @author Xudong Zhang
 */
public class ShellSort {
	public static void sort(int[] a) {
		for(int gap = a.length/2; gap>0; gap = gap/2) {//步长,每这么多个步长分为一组
			//直接从第gap个开始，进行直接插入排序
			for(int i=gap; i<a.length; i++) {
				//跟前面的每一个进行比较，选择插入
				for(int j=i;j-gap>=0;j = j-gap) {
					if(a[j]<a[j-gap]) {
						int tmp = a[j];
						a[j] = a[j-gap];
						a[j-gap] = tmp;
					}
				}
			}
		}
	}
	//希尔排序
	public static void sort2(int[] nums) {
		for (int gap = nums.length / 2; gap > 0; gap = gap / 2) {
			for (int i = gap; i < nums.length; i = i + 1) {
				int cur = nums[i];
				int j = i - gap;
				while (j >= 0 && nums[j] > cur) {
					//这里是插入排序，总的来说sort2更像是插入排序的改进
					nums[j + gap] = nums[j];
					j = j - gap;

				}
				nums[j + gap] = cur;
			}
		}
	}

	
	public static void main(String[] args) {
		int[] array = {5,9,6,7,2,3,4};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
