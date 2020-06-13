package tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tmp {

	public static void swap(int i,int j,int[] array) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		int[] array = {5,4,9,6,7,2,3};
		int[] array2 =  {1, 7, 18, 9, 5, 6};
		System.out.println(Arrays.toString(array));
		int[]  res = sort(array);
		System.out.println(Arrays.toString(res));
	}
	//递增
	private static int[] sort(int[] nums) {
		int len = Integer.MIN_VALUE;
		for(int i:nums){
			len = Math.max(len,i);
		}
		int[] res = new int[nums.length];
		int[] help = new int[len+1];
		Arrays.fill(help,0);

		for(int i=0;i<nums.length;i++){
			help[nums[i]]++;
		}
		for(int i=1;i<len+1;i++){
			help[i] +=help[i-1];
		}
		for(int i=nums.length-1;i>=0;i--){
			res[help[nums[i]]-1] = nums[i];
			help[nums[i]] -=1;
		}
		return res;

	}

}
