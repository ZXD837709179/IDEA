package thread;

import java.util.*;

/**
 * @Auther: Xudong Zhang
 * @Date: 2020/3/23 18:49
 * @Description:
 */
public class Adf {
    public static void main(String[] args){
        String[] words = new String[]{"cat","bt"};
        System.out.println(Arrays.asList(findContinuousSequence(9)));
    }
    public static int[][] findContinuousSequence(int target) {
        //比较麻烦的是不知道二维数组的第一维是多少
        //间接地将数组放到列表，再根据列表的长度建立二维数组
        int l =1;
        int r=2;
        int sum = 0;
        ArrayList<int[]> list = new ArrayList();
        while(r<target/2+2){
            sum = (l+r)*(r-l+1)/2;
            if(sum < target){
                r++;
            }else if(sum>target){
                l++;
            }else{
                int[] tmp = new int[r-l+1];
                for(int i=0;i<r-l+1;i++){
                    tmp[i] = i+l;
                }
                list.add(tmp);
                r++;
            }
        }
        System.out.println(list.size());
        int[][] rel = new int[list.size()][];
        for(int i=0;i<list.size();i++){
            rel[i] = list.get(i);
        }

        return rel;
    }
}
