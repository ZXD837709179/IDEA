package sort;

import java.util.Arrays;

/**
 * @auther: Xudong Zhang
 * @create: 2020/4/16 21:44
 * @description: 计数排序，时间复杂度O(n)
 */
public class CountSort {


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
        while(len-->0){

        }
        for(int i:nums){
            len = Math.max(len,i);//辅助数组的长度
        }
        int[] res = new int[nums.length];
        int[] help = new int[len+1];
        Arrays.fill(help,0);

        for(int i=0;i<nums.length;i++){
            help[nums[i]]++;//辅助数组记录原数组值位下标的个数
        }
        for(int i=1;i<len+1;i++){
            help[i] +=help[i-1];//计算某个元素处于第几个
        }
        for(int i=0;i<nums.length;i++){
            res[help[nums[i]]-1] = nums[i];//结果从零开始要减一
            help[nums[i]] -=1;
        }
        return res;
    }
}
