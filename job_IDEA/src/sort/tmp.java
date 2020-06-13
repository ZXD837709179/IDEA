package sort;

import javafx.util.Builder;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;

public class tmp {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 6, 2, 9, 5};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] array = {5, 4, 9, 6, 7, 2, 3};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    //¿ìÅÅ
    public static void sort(int[] nums) {
        quick2(nums,0,nums.length-1);
    }

    public static void quick(int[] nums,int start,int end){
        if(start>=end) {
            return;
        }
        int target = nums[start];
        int l = start;
        int r = end;
        while(l<r){
            while(l<r && nums[r]>=target){
                r--;
            }
            while(l<r && nums[l]<=target){
                l++;
            }
            if(l<r){
                swap(nums,l,r);
            }
        }
        swap(nums,l,end);
        quick(nums,start,l-1);
        quick(nums,l+1,end);
    }

    public static void quick2(int[] nums,int start,int end){
        if(start>=end) {
            return;
        }
        int target = nums[start];
        int l= start;
        int r = end;
        int cur = start;
        while(cur<=r){
            if(nums[cur]<target){
                swap(nums,l,cur);
                cur++;
                l++;
            }else if(nums[cur]==target){
                cur++;
            }else{
                swap(nums,r,cur);
                r--;
            }
        }
        quick2(nums,start,l-1);
        quick2(nums,r+1,end);
    }


    public static void build(int[] nums,int i,int length){
        int tmp = nums[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length && nums[k+1]<nums[k]){
                k++;
            }
            if(tmp>nums[k]){
                nums[i] = nums[k];
                i = k;
            }else{
                break;
            }
        }
        nums[i] = tmp;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
