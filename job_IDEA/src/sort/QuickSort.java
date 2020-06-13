package sort;

import java.util.Arrays;
/**
 * 时间复杂度 nlogn
 * 空间复杂度 nlogn
 * @author Xudong Zhang
 *
 */
public class QuickSort {

	public static void quick3(int[] nums,int start,int end){
		if(start>=end) {
			return;
		}
		int target = nums[start];
		int l= start;
		int r = end;
		int cur = start;
		while(cur<=r){
			if(nums[cur]<target){
				swap(l,cur,nums);
				cur++;
				l++;
			}else if(nums[cur]==target){
				cur++;
			}else{
				swap(r,cur,nums);
				r--;
			}
		}
		quick3(nums,start,l-1);
		quick3(nums,r+1,end);
	}


	//迭代，要有判断出口
	//升序
	public static void sort(int[] a,int start,int end) {
		if(a == null || start>end) {
			return;
		}
		//最后一个数作为基准数,left，right作为左右
		int left = start;
		int right = end;
		int key = a[end];
		while(left<right) {
			while(left<right && a[left]<=key) {
				left++;
			}
			while(left<right && a[right]>=key) {
				right--;
			}
			if(left<right) {//可能是因为left超过了right而来到了这一步
				swap(left, right, a);
			}

		}
		swap(end, right, a);
		//此时分成了左右两个部分
		sort(a, start, left-1);
		sort(a, left+1,end);
	}
	
	//降序
	public static void sort2(int[] a, int start, int end) {
		if(a==null || start>=end) {
			return;
		}
		int left = start;
		int right = end;
		//左边为参考点，那么就要从右边开始比较,因为可能第一个while循环之后就left>=right;
		//这样子绝对可以保证交换过去的是right比nums[start]大
		int key = a[start];
		while(left<right) {
			while(left<right && a[right]<=key) {
				right--;
			}
			while(left<right && a[left]>=key) {
				left++;
			}

			if(left<right) {
				swap(left, right, a);
			}
		}
		System.out.println(left==right);
		swap(start, left, a);
		sort2(a, start, left-1);
		sort2(a, left+1, end);
	}

	public static void swap(int i,int j,int[] array) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public static void main(String[] args) {
		int[] array = {5,4,9,6,7,2,3};
		int[] array2 =  {1, 7, 18, 9, 5, 6};
		System.out.println(Arrays.toString(array2));
		sort2(array2,0,array2.length-1);
		System.out.println(Arrays.toString(array2));
	}
	
}
