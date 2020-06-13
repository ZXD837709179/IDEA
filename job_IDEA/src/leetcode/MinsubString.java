package leetcode;
import java.util.*;
/**
 * @auther: Xudong Zhang
 * @create: 2020/5/21 19:03
 * @description:给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinsubString {
    public static void main(String[] args) {
        String s = new MinsubString().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) return "";
        int len = Integer.MAX_VALUE;
        String res ="";
        int l = 0,r = 0;
        char[] chart = t.toCharArray();
        HashMap<Character,Integer> mapt = new HashMap();
        for(char c:chart){
            mapt.put(c,mapt.getOrDefault(c,0)+1);
        }
        int count = 0;
        HashMap<Character,Integer> mapp = new HashMap();
        while(r<s.length()){
            char tmp = s.charAt(r);
            if(mapt.containsKey(tmp)){
                mapp.put(tmp,mapp.getOrDefault(tmp,0)+1);
                if(mapt.get(tmp).equals(mapp.get(tmp))){
                    count++;
                }
            }

            while(count==mapt.size()){
                if(r-l+1<len){
                    len = r-l+1;
                    res = s.substring(l,r+1);
                }
                char tc = s.charAt(l);
                if(mapp.containsKey(tc)){
                    mapp.put(tc,mapp.getOrDefault(tc,0)-1);
                    if(mapt.get(tc)>mapp.get(tc)){
                        count--;
                    }
                }
                l++;
            }
            r++;
            // if(mapp.size()==mapt.size()){
            //     boolean flag = true;
            //     for(Character c:mapt.keySet()){
            //         if(mapp.get(c)>=mapt.get(c)){
            //             continue;
            //         }else{
            //             flag = false;
            //             break;
            //         }
            //     }
            //     if(flag){
            //         if(j-i+1<len){
            //             len = j-i+1;
            //             res = s.substring(i,j);
            //             while()
            //         }
            //     }
            // }

        }
        return res;
    }
}
