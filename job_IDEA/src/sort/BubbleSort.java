package sort;

import java.util.Arrays;

/**
 * 冒泡排序，一种稳定的排序算法
 * 平均时间复杂度是 n*n，最佳是n，最坏是n*n,效率不行
 * 空间复杂度O(1)
 * @author Xudong Zhang
 * 
 *
 */
public class BubbleSort {
	//升序排列
	public static void sort(int[] array) {
		boolean flag = true;
		for(int i=array.length-1; i>0; i--) {
			for(int j = 0; j<i; j++) {
				if(array[j]>array[j+1]) {
					swap(j,j+1,array);
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	//降序排列
	public static void sort2(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j = array.length-1;j>i;j--) {
				if(array[j]>array[j-1]) {
					swap(j, j-1, array);
				}
			}
		}
	}
	
	public static void swap(int i,int j,int[] array) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		int[] array = {1,5,7,3,4,8,9};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
