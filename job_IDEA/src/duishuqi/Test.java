package duishuqi;

import java.util.Arrays;
import java.util.Stack;

/**
 * @auther: Xudong Zhang
 * @create: 2020/6/11 09:20
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        boolean flag = true;
        for(int i=0;i<10000;i++){
            int[] nums = generateRandomArray(10, 10);
            int[] res1 = dailyTemperatures(nums);
            int[] res2 = juedui(nums);
            if (!isEquals(res1,res2)){
                flag = false;
                System.out.println(Arrays.toString(nums));
                break;
            }
        }
        System.out.println(flag?"你真棒":"你又错了");

    }

    //生成一个随机大小，最大数随机的数组,maxSize为数组最大个数，maxNum为数组元素最大值
    public static int[] generateRandomArray(int maxSize, int maxNum) {
        int[] arr = new int[(int) ((maxSize+1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*(maxNum+1)) - (int)(Math.random()*maxNum);
        }
        return arr;
    }

    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 != null && arr2 == null || arr1 == null && arr2 != null) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        return true;
    }

    public static int[] juedui(int[] nums){
        int len = nums.length;
        int[] res = new int[len];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }


    public static int[] dailyTemperatures(int[] T) {
        //递减栈
        Stack<Integer> stack = new Stack();
        int[] res = new int[T.length];
        if (T.length == 1) {
            return new int[]{0};
        }
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (T[i] <= T[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                        int index = stack.pop();
                        res[index] = i - index;
                    }
                    stack.push(i);
                }
            }

        }
        return res;
    }
}
