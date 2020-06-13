package other;

import leetcode.Shan;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @auther: Xudong Zhang
 * @create: 2020/6/4 11:32
 * @description:
 */
//https://blog.csdn.net/duoduo18up/article/details/80686284
public class KMP {
    public static void main(String[] args) {
        int[] nums = new KMP().getNext("DABCDABDE");
        System.out.println(Arrays.toString(nums));

        System.out.println(new KMP().con("adcbcdcde","dc"));
    }

    public int con(String str1,String str2){
        if(str1.length()==0 || str2.length()==0 || str2.length()>str1.length()){
            return -1;
        }
        int[] next = getNext(str2);
        int i=0,j=0;
        while(i<str1.length() && j< str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else if(next[j]==-1){
                i++;
            }else{
                j=next[j];
            }
        }
        return j==str2.length()?i-j:-1;
    }

    public int[] getNext(String str){
        char[] chars = str.toCharArray();
        if(chars.length==1){
            return new int[]{-1};
        }
        if(chars.length==2){
            return new int[]{-1,0};
        }
        int[] res = new int[chars.length];
        res[0] = -1;
        res[1] = 0;
        int cn = 0;//前一个元素所在位置的next数组的值
        int i=2;//要求的是next第i个位置的值
        while(i<chars.length){
            if(chars[i-1] == chars[cn]){
                res[i++] = ++cn;
            }else if(cn<=0){
                res[i++] = 0;
            }else{
                cn = res[cn];
            }
        }
        return res;
    }
}
