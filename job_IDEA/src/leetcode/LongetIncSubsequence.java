package leetcode;

import org.junit.Test;

import javax.lang.model.element.VariableElement;

/**
 * @description:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @author:ZXD
 * @create:2020-03-14-星期六
 */
public class LongetIncSubsequence {
	public static int test1(int[] nums){
		//第一种方法想到动态规划
		int size = nums.length;
		if(size<2) {
			return size;
		}
		//dp[i]的含义是nums中的第i个在子序列中的长度
		int[] dp = new int[size];
		dp[0] = 1;
		int rel = 1;
		for (int i = 1; i < size; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(nums[i]>nums[j]){
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max+1;
			rel = Math.max(rel, dp[i]);
		}
		return rel;
	}

	public static int test2(int[] nums){
		//贪心+二分查找
		/**
		 * dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
		 *         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
		 *         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
		 *         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
		 *            数组尾部, 并将最长递增序列长度maxL加1
		 *         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
		 */
		int maxL = 0;
		int[] dp = new int[nums.length];
		for(int num : nums) {
			// 二分法查找, 也可以调用库函数如binary_search
			int lo = 0, hi = maxL;
			while(lo < hi) {
				int mid = lo+(hi-lo)/2;
				if(dp[mid] < num)
					lo = mid+1;
				else
					hi = mid;
			}
			dp[lo] = num;
			if(lo == maxL)
				maxL++;
		}
		return maxL;
	}
	public static void main(String[] args) {
		System.out.println(test1(new int[]{10,9,2,5,3,7,101,18}));
		System.out.println(test2(new int[]{10,9,2,5,3,7,101,18}));
	}

}
