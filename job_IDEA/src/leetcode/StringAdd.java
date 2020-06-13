package leetcode;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/19 17:50
 * @description:
 */
public class StringAdd {
    public static void main(String[] args) {
        String r = add("78", "24");
        System.out.println(r);
    }
    public  String sum (ArrayList<String> numbers) {
        // write code here
        String res = "0";
        for(String s:numbers){
            res = add(res,s);
        }
        return res;
    }

    public static String add(String s1,String s2){
        String res = "";
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        int i=char1.length-1;
        int j=char2.length-1;
        int carry = 0;
        while(i>=0 || j>=0 || carry>0){
            int sum  = 0;
            if(i>=0){
                sum +=char1[i]-'0';
            }
            if(j>=0){
                sum +=char2[j]-'0';
            }
            sum += carry;
            if(sum>9){
                sum = sum%10;
                carry = 1;

            }else{
                carry = 0;
            }
            res = res+sum;
            i--;
            j--;
        }
        return new StringBuilder(res).reverse().toString();
    }
}
