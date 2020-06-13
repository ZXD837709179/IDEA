package sort;

import java.util.*;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/22 20:33
 * @description:
 */
public class BucketSort {

    public static void sort(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int bucketSize = (max-min)/(nums.length)+1;
        List<Integer>[] help = new List[bucketSize];
        for(int i=0;i<nums.length;i++){
            int num = (nums[i]-min)/nums.length;
            if(help[num]==null){
                help[num] = new ArrayList<>();
            }
            help[num].add(nums[i]);
        }
        for(int i=0;i<bucketSize;i++){
            if(help[i]!=null){
                Collections.sort(help[i]);
                for(int tmp:help[i]){
                    System.out.print(tmp+" ");
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {100,12,4567,787,54,96};
        System.out.println(Arrays.toString(array));
        sort(array);

    }


}
