package sort;

import java.util.Arrays;
/**
 * 时间复杂度nlogn
 * @author Xudong Zhang
 *
 */
public class MergeSort {
	public static int[] sort(int[] a) {
		if(a.length<=1) {
			return a;
		}
		int length = a.length;
		int[] left = Arrays.copyOfRange(a, 0, length/2);
		int[] right = Arrays.copyOfRange(a, length/2, length);
		return Merge(sort(left), sort(right));
	}
	
	public static int[] Merge(int[] left, int[] right) {
		if(left == null) return right;
		if(right == null) return left;
		int[] rel = new int[left.length+right.length];
		int i=0;//left的下标
		int j=0;//right的下标
		int k=0;//rel的下标
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				rel[k++] = left[i++];
			}else {
				rel[k++] = right[j++];
			}
		}
		if(i>=left.length) {
			//剩下right没有合并完
			while(j<right.length) {
				rel[k++]=right[j++];
			}
		}else {
			//剩下left没有合并完
			while(i<right.length) {
				rel[k++]=left[i++];
			}
		}
		
		return rel;
	}

	public static void main(String[] args) {
		int[] array = {5,9,6,7,2,3,4,1};
		System.out.println(Arrays.toString(array));
		int[] rel = sort(array);
		System.out.println(Arrays.toString(rel));
	}
}
