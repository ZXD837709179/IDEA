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
        //�Ƚ��鷳���ǲ�֪����ά����ĵ�һά�Ƕ���
        //��ӵؽ�����ŵ��б��ٸ����б�ĳ��Ƚ�����ά����
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
